package com.company.Controllers;

import com.company.MyRunnable;
import com.company.TestFrame;
import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Graph;
import com.company.elementsOfGraph.Node;

import java.util.Iterator;

/**
 * Created by alex on 21.02.2017.
 */
public class Controller {
    private TestFrame testFrame;
    private Node isMovingNode;
    private Graph graph;
    private boolean isHaveMovingNode;
    private Node[] masOfConnectingNodes;
    private int countOfConectingNodes;
    private Edge tempEdge;
    private FileManipulations fileManipulations;

    public Controller(TestFrame testFrame) {
        isMovingNode = null;

        this.testFrame = testFrame;
        graph = new Graph(testFrame);
        fileManipulations = new FileManipulations(this);
        masOfConnectingNodes = new Node[2];
    }

    public void addNode(int nodeX, int nodeY) {
        graph.addNode(new Node(nodeX - 15, nodeY - 15));
        testFrame.setGraph(graph);
    }

    private void addEdge(Edge edge) {
        graph.addEdge(edge);
        testFrame.setGraph(graph);
    }

    public void ifActivateNode(int posX, int posY) {
        for (Node node : graph.getNodeList()) {
            if (node.isOverlapWithCursor(posX, posY))
                node.setActive(true);
            else node.setActive(false);
        }
    }

    public void setIdtfForActiveNode(String idtf) {
        for (Node node : graph.getNodeList()) {
            if (node.isActive())
                if (idtf != null)
                    node.setIdentificator(idtf);
        }
    }

    public void deleteActiveNode() {
        Iterator<Node> nodeIterator = graph.getNodeList().iterator();
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            if (node.isActive()) {
                Iterator<Edge> edgeIterator = graph.getEdgeList().iterator();
                while (edgeIterator.hasNext()) {
                    Edge edge = edgeIterator.next();
                    if ((node == edge.getFirstNode()) || node == edge.getSecondNode()) {
                        edgeIterator.remove();
                    }
                }
                nodeIterator.remove();
            }
        }
        // testFrame.setGraph(graph);
    }

    public void deleteEnteredEdge() {
        Iterator<Edge> edgeIterator = graph.getEdgeList().iterator();
        while (edgeIterator.hasNext()) {
            if (edgeIterator.next().isActive())
                edgeIterator.remove();
        }
    }

    public void setMovingNode(int posX, int posY) {
        for (Node node : graph.getNodeList()) {
            if (node.isOverlapWithCursor(posX, posY)) {
                isMovingNode = node;
                isHaveMovingNode = true;
            }
        }
    }

    public void deleteMovingNode() {
        isMovingNode = null;
        isHaveMovingNode = false;
    }

    public void moveNode(int posX, int posY) {

        for (Node node : graph.getNodeList()) {
            if (node == isMovingNode) {
                node.setCenterX(posX);
                node.setCenterY(posY);
            }
        }
    }

    public void addNodeForConnection(int positionMouseX, int positionMouseY) { //  System.out.println("sddsfaads");
        for (Node node : testFrame.getGraph().getNodeList()) {
            if (node.isEntered()) {
                masOfConnectingNodes[countOfConectingNodes] = node;
                countOfConectingNodes++;
                if (countOfConectingNodes == 1) {
                    masOfConnectingNodes[1] = new Node(positionMouseX - 15, positionMouseY - 15);
                    tempEdge = new Edge(masOfConnectingNodes[0], masOfConnectingNodes[1]);
                    addEdge(tempEdge);
                }
                if (countOfConectingNodes == 2) {
                    countOfConectingNodes = 0;
                    tempEdge.setSecondNode(masOfConnectingNodes[1]);
                    masOfConnectingNodes[0] = null;
                    masOfConnectingNodes[1] = null;
                }
            }
        }

    }

    public void deleteTempEdge() {
        Iterator<Edge> edgeIterator = graph.getEdgeList().iterator();
        Edge edge;
        while (edgeIterator.hasNext()) {
            edge = edgeIterator.next();
            if (tempEdge != null && tempEdge == edge)
                edgeIterator.remove();
        }

    }


    public void toChangePositionOfTempEdge(int x, int y) {
        if (countOfConectingNodes == 1) {
            masOfConnectingNodes[1].setCenterX(x);
            masOfConnectingNodes[1].setCenterY(y);
        }

    }

    public boolean isHaveMovingNode() {
        return isHaveMovingNode;
    }

    public void ifEnteredNode(int posX, int posY) {
        for (Node node : graph.getNodeList()) {
            if ((node.isOverlapWithCursor(posX, posY)) && (node.isActive() != true))
                node.setEntered(true);
            else if (!node.isActive())
                node.setEntered(false);
        }
    }

    public void ifEnterEdge(int posX, int posY) {
        for (Edge edge : graph.getEdgeList()) {
            edge.setEntered(posX, posY);
        }
    }

    public boolean haveActiveNode() {
        for (Node node : graph.getNodeList())
            if (node.isActive())
                return true;
        return false;
    }


    public boolean haveActiveEdge() {
        for (Edge edge : graph.getEdgeList()) {
            if (edge.isActive()) {
                return true;
            }
        }
        return false;
    }

    public void setWeigth(String string) {
        for (Edge edge : graph.getEdgeList()) {
            if (edge.isActive()) {
                if (string != null)
                    edge.setWeigth(string);
                return;
            }
        }
    }

    public void SaveGraphInFile() {
        fileManipulations.SaveGraph(graph);
    }

    public void loadGraphFromFile() {
        //  if(fileManipulations.loadGraph(graph))
        graph.deleteOllElements();
        fileManipulations.loadGraph(graph);
    }

    public void doTask() {
        Thread thread = new Thread(new MyRunnable(graph, null, null));
        thread.start();
    }

    public void editScrollPane(int posMouseX, int posMouseY) {
      System.out.println(testFrame.getjLabel().getX()+" "+testFrame.getjLabel().getY());
    }
}
