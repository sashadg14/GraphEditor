package com.company.elementsOfGraph;

import java.awt.*;

/**
 * Created by alex on 19.02.2017.
 */
public class Edge {
    private Node firstNode;
    private Node secondNode;
    private boolean isActive = false;
    private String weigth = "";
    private boolean visited = false;

    public Edge(Node node1, Node node2) {
        this.firstNode = node1;
        this.secondNode = node2;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public void setSecondNode(Node secondNode) {
        this.secondNode = secondNode;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getSecondNode() {
        return secondNode;
    }
    private boolean isEdgeHaveActiveNode() {
        return (firstNode.isEntered() || secondNode.isEntered());
    }
    public void setEntered(int posX, int posY) {   //System.out.println(firstNode.getCenterX()+" "+secondNode.getCenterX()+" "+posX);
        double H;
        isActive = false;
        // if(((firstNode.getCenterX()-posX)<-15&(firstNode.getCenterY()-posY)<-15)||((posX-secondNode.getCenterX())<-15&(posY-secondNode.getCenterY())<-15))
        if (((posX < firstNode.getCenterX() + 15 & posX > secondNode.getCenterX() + 15) || (posX < secondNode.getCenterX() + 15 & posX > firstNode.getCenterX() + 15)) & !isEdgeHaveActiveNode()) {
            H = (((firstNode.getCenterY() - secondNode.getCenterY()) * posX + (secondNode.getCenterX() - firstNode.getCenterX()) * posY +
                    (firstNode.getCenterX() * secondNode.getCenterY() - secondNode.getCenterX() * firstNode.getCenterY())) /
                    Math.pow((secondNode.getCenterX() - firstNode.getCenterX()) * (secondNode.getCenterX() - firstNode.getCenterX()) +
                            (secondNode.getCenterY() - firstNode.getCenterY()) * (secondNode.getCenterY() - firstNode.getCenterY()), 0.5));
            if (Math.abs(H) < 15) {
                //color = Color.orange;
                isActive = true;
            }
            // else color=Color.gray;
            //  System.out.println(" H===="+H);
        }

    }
}
