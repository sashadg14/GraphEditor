package com.company.listeners.mouseListeners;

import com.company.Controllers.Controller;
import com.company.TestFrame;
import com.company.elementsOfGraph.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by alex on 13.03.2017.
 */
public class EdgeListener implements MouseListener {
    TestFrame testFrame;
    Controller controller;
    Node node;
    public EdgeListener(TestFrame testFrame, Controller controller)
    {
        this.testFrame=testFrame;
        this.controller=controller;
    }
    public void mouseClicked(MouseEvent e) {
        //node = new Node(e.getX(),e.getY());
        {
            //for(Node node:testFrame.getGraph().getNodeList())
            if(e.getButton()==1)
            {
              //  if(node.isEntered())
                    controller.addNodeForConnection(e.getX(),e.getY());
            }
            else controller.deleteTempEdge();
        }
        testFrame.renderAllElements();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
            if(controller.isHaveMovingNode())
                controller.deleteMovingNode();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {

    }
}
