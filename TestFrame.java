package com.company;


import com.company.Controllers.Controller;
import com.company.elementsOfGraph.Edge;
import com.company.elementsOfGraph.Graph;
import com.company.elementsOfGraph.Node;
import com.company.listeners.mouseListeners.*;
import com.company.listeners.mouseMotionListeners.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class TestFrame {
    BufferedImage imag;
    JLabel jLabel;
    Graph graph;
    Controller controller;
    EditListener editListener;
    EdgeListener edgeListener;
    DeleteButtonListener deleteButtonListener;
    IdtfEditButtonListener idtfEditButtonListener;

    EditMouseMotionListener editMouseMotionListener;
    EdgeMouseMotionListener edgeMouseMotionListener;
    DeleteButtonMouseMotionListener deleteButtonMouseMotionListener;
    IdtfEditButtonMouseMotionListeners idtfEditButtonMouseMotionListeners;

    Graphics2D graphics2D;
    JToolBar toolbar;
    final JButton arrowButton;
    final JButton edgeButton;
    final JButton deleteButton;
    final JButton editItdfButton;
    final JButton taskButton;
    JFrame frame;
    JScrollPane jsp;
    private int scrollPositionX, scrollPositionY;

    public TestFrame() {
        controller = new Controller(this);
        frame = new JFrame("KBE: second edition");

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        arrowButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton = new JButton(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        imag = new BufferedImage(2200, 2000, BufferedImage.TYPE_INT_RGB);
        jLabel = new JLabel(new ImageIcon(imag));
        graphics2D = (Graphics2D) imag.getGraphics();
        editListener = new EditListener(this, controller);
        edgeListener = new EdgeListener(this, controller);
        deleteButtonListener = new DeleteButtonListener(this, controller);
        idtfEditButtonListener = new IdtfEditButtonListener(this, controller);

        editMouseMotionListener = new EditMouseMotionListener(this, controller);
        edgeMouseMotionListener = new EdgeMouseMotionListener(this, controller);
        deleteButtonMouseMotionListener = new DeleteButtonMouseMotionListener(this, controller);
        idtfEditButtonMouseMotionListeners = new IdtfEditButtonMouseMotionListeners(this, controller);

        jsp = new JScrollPane(jLabel);
        graph = new Graph(this);
        frame.setSize(1000, 800);
        jsp.setPreferredSize(new Dimension(1550, 0));
        // jsp.setBounds(30, 30, 500, 500);
        frame.add(jsp, BorderLayout.EAST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        creatingTolbar();
        creatingFileMenu();

        System.out.println(jsp.getHeight() + "----" + jsp.getWidth());
        jsp.getViewport().setViewPosition(new Point(1100, 1000));
        //System.out.println(jsp.getAlignmentX()+"  _"+jsp.get);
        // String[] mas1=mas[0].split()

    }

    public void resizePanel(int width, int heigth) {
        imag = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        jLabel.setIcon(new ImageIcon(imag));
        graphics2D = (Graphics2D) imag.getGraphics();
    }

    public JScrollPane getJsp() {
        return jsp;
    }

    private void addListnersForEditGraph() {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel.removeMouseListener(edgeListener);
        jLabel.removeMouseMotionListener(edgeMouseMotionListener);
        jLabel.removeMouseListener(deleteButtonListener);
        jLabel.removeMouseMotionListener(deleteButtonMouseMotionListener);
        jLabel.removeMouseListener(idtfEditButtonListener);
        jLabel.removeMouseMotionListener(idtfEditButtonMouseMotionListeners);
        jLabel.addMouseListener(editListener);
        jLabel.addMouseMotionListener(editMouseMotionListener);
    }

    public void addListenersForAddingEdges() {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edgeActive.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel.removeMouseListener(editListener);
        jLabel.removeMouseMotionListener(editMouseMotionListener);
        jLabel.removeMouseListener(deleteButtonListener);
        jLabel.removeMouseMotionListener(deleteButtonMouseMotionListener);
        jLabel.removeMouseListener(idtfEditButtonListener);
        jLabel.removeMouseMotionListener(idtfEditButtonMouseMotionListeners);

        jLabel.addMouseListener(edgeListener);
        jLabel.addMouseMotionListener(edgeMouseMotionListener);
    }

    public void addListnersForDeletingElements() {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\deleteActive.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel.removeMouseListener(editListener);
        jLabel.removeMouseMotionListener(editMouseMotionListener);
        jLabel.removeMouseListener(edgeListener);
        jLabel.removeMouseMotionListener(edgeMouseMotionListener);
        jLabel.removeMouseListener(idtfEditButtonListener);
        jLabel.removeMouseMotionListener(idtfEditButtonMouseMotionListeners);

        jLabel.addMouseListener(deleteButtonListener);
        jLabel.addMouseMotionListener(deleteButtonMouseMotionListener);
    }

    public void addListenersForEditingValues() {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEditActive.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButton.png"));

        jLabel.removeMouseListener(editListener);
        jLabel.removeMouseMotionListener(editMouseMotionListener);
        jLabel.removeMouseListener(edgeListener);
        jLabel.removeMouseMotionListener(edgeMouseMotionListener);
        jLabel.removeMouseListener(deleteButtonListener);
        jLabel.removeMouseMotionListener(deleteButtonMouseMotionListener);

        jLabel.addMouseListener(idtfEditButtonListener);
        jLabel.addMouseMotionListener(idtfEditButtonMouseMotionListeners);
    }

    public void addListenersForTaskRealization() {
        arrowButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\arrowNonActive.png"));
        edgeButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\edge.png"));
        deleteButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\delete.png"));
        editItdfButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\textEdit.png"));
        taskButton.setIcon(new ImageIcon("E:\\GraphEditor\\src\\com\\company\\resourses\\taskButtonActive.png"));

        jLabel.removeMouseListener(editListener);
        jLabel.removeMouseMotionListener(editMouseMotionListener);
        jLabel.removeMouseListener(edgeListener);
        jLabel.removeMouseMotionListener(edgeMouseMotionListener);
        jLabel.removeMouseListener(deleteButtonListener);
        jLabel.removeMouseMotionListener(deleteButtonMouseMotionListener);

        jLabel.addMouseListener(new TaskMouseListener(this, controller));
        jLabel.addMouseMotionListener(new TaskMouseMotionListener(this, controller));
    }

    private void creatingFileMenu() {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        fileMenu.add(new JMenuItem(new AbstractAction("Сохранить как...") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.SaveGraphInFile();
            }
        }));
        fileMenu.add(new JMenuItem(new AbstractAction("Загрузить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.loadGraphFromFile();
            }
        }));
        fileMenu.add(new JMenuItem(new AbstractAction("выполнить") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.doTask();
            }
        }));
        JMenu graphMenu = new JMenu("Граф");
        menuBar.add(graphMenu);
        graphMenu.add(new JMenuItem(new AbstractAction("Редактирование") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addListnersForEditGraph();
            }
        }));
        graphMenu.add(new JMenuItem(new AbstractAction("Добавить дугу") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addListenersForAddingEdges();
            }
        }));
        graphMenu.add(new JMenuItem(new AbstractAction("Удаление элемента") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addListnersForDeletingElements();
            }
        }));
        graphMenu.add(new JMenuItem(new AbstractAction("Задать значение") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addListenersForEditingValues();
            }
        }));
    }

    private void creatingTolbar() {
        toolbar = new JToolBar("Toolbar", JToolBar.VERTICAL);

        arrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addListnersForEditGraph();

            }
        });
        toolbar.add(arrowButton);
        edgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addListenersForAddingEdges();
            }
        });
        toolbar.add(edgeButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addListnersForDeletingElements();
            }
        });
        toolbar.add(deleteButton);
        editItdfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addListenersForEditingValues();
            }
        });
        toolbar.add(editItdfButton);
        taskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addListenersForTaskRealization();
                controller.doTask();
            }
        });
        toolbar.add(taskButton);

        frame.add(toolbar);
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public void renderAllElements() {
        getGraphics2D().setColor(Color.WHITE);
        getGraphics2D().fillRect(0, 0, getImag().getWidth(), getImag().getHeight());
        for (Edge edge : graph.getEdgeList()) {
            renderEdge(edge);
        }
        for (Node node : graph.getNodeList()) {
            renderNode(node);
        }
        getjLabel().updateUI();
    }

    public void renderEdge(Edge edge){
        graphics2D.setColor(Color.gray);
        if(edge.isActive()){
            graphics2D.setColor(Color.orange);
        }
        if(edge.isVisited()){
            graphics2D.setColor(Color.cyan);
        }
        graphics2D.setStroke(new BasicStroke(10));
        if (edge.getFirstNode()!=edge.getSecondNode())
            graphics2D.drawLine(edge.getFirstNode().getCenterX() + 15, edge.getFirstNode().getCenterY() + 15, edge.getSecondNode().getCenterX() + 15, edge.getSecondNode().getCenterY() + 15);
        else {
            graphics2D.fillOval(edge.getFirstNode().getCenterX() + 10, edge.getFirstNode().getCenterY() - 15, 60, 60);
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillOval(edge.getFirstNode().getCenterX() + 20, edge.getFirstNode().getCenterY() - 5, 40, 40);
        }

        graphics2D.setColor(Color.blue);
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 20));
        graphics2D.drawString(edge.getWeigth(), (edge.getFirstNode().getCenterX() + 30 + edge.getSecondNode().getCenterX() + 30) / 2,
                (edge.getFirstNode().getCenterY() + 30 + edge.getSecondNode().getCenterY() + 30) / 2);

    }
    public void renderNode(Node node){
        graphics2D.setColor(node.getColorOfNode());
        graphics2D.fillOval(node.getCenterX(), node.getCenterY(), 30, 30);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval(node.getCenterX() + 5, node.getCenterY() + 5, 20, 20);
        graphics2D.setColor(Color.blue);
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC + Font.BOLD, 20));
        graphics2D.drawString(node.getIdentificator(), node.getCenterX() + 30, node.getCenterY() + 30);
        graphics2D.setColor(Color.white);
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public BufferedImage getImag() {
        return imag;
    }

    public Graphics2D getGraphics2D() {
        return graphics2D;
    }
}