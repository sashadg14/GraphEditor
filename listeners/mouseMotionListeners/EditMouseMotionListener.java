package com.company.listeners.mouseMotionListeners;

import com.company.Controllers.Controller;
import com.company.TestFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by alex on 14.03.2017.
 */
public class EditMouseMotionListener implements MouseMotionListener {

    TestFrame testFrame;
    Controller controller;

    public EditMouseMotionListener(TestFrame testFrame, Controller controller) {
        this.testFrame = testFrame;
        this.controller = controller;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        {
            if (controller.isHaveMovingNode()) {
                controller.moveNode(mouseEvent.getX(), mouseEvent.getY());
                int deltaX,deltaY;
                deltaX=Math.abs(testFrame.getjLabel().getX())+testFrame.getJsp().getWidth();
                deltaY=Math.abs(testFrame.getjLabel().getY())+testFrame.getJsp().getHeight();
                // System.out.println(Integer.toString(mouseEvent.getX()-deltaX)+"---"+Integer.toString(mouseEvent.getY()-deltaY));
                System.out.println((testFrame.getjLabel().getX()-testFrame.getJsp().getWidth()+mouseEvent.getX())+" "+
                        (testFrame.getjLabel().getY()-testFrame.getJsp().getHeight()+mouseEvent.getY()));

                if(testFrame.getjLabel().getX()-testFrame.getJsp().getWidth()+mouseEvent.getX()>-40)
                testFrame.getJsp().getViewport().setViewPosition(new Point((int)testFrame.getJsp().getViewport().getViewPosition().getX()+50,
                        (int)testFrame.getJsp().getViewport().getViewPosition().getY()));
                if(testFrame.getjLabel().getY()-testFrame.getJsp().getHeight()+mouseEvent.getY()>-40)
                    testFrame.getJsp().getViewport().setViewPosition(new Point((int)testFrame.getJsp().getViewport().getViewPosition().getX(),
                            (int)testFrame.getJsp().getViewport().getViewPosition().getY()+50));

                if(testFrame.getjLabel().getX()-testFrame.getJsp().getWidth()+mouseEvent.getX()<testFrame.getjLabel().getX()-testFrame.getJsp().getWidth()-40)
                    testFrame.getJsp().getViewport().setViewPosition(new Point((int)testFrame.getJsp().getViewport().getViewPosition().getX()-50,
                            (int)testFrame.getJsp().getViewport().getViewPosition().getY()));
                /*if(testFrame.getjLabel().getY()-testFrame.getJsp().getHeight()+mouseEvent.getY()>-40)
                    testFrame.getJsp().getViewport().setViewPosition(new Point((int)testFrame.getJsp().getViewport().getViewPosition().getX(),
                            (int)testFrame.getJsp().getViewport().getViewPosition().getY()+50));*/


            }
            //  controller.ifEnterEdge(mouseEvent.getX(), mouseEvent.getY());
        }
        testFrame.renderAllElements();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        controller.ifEnteredNode(mouseEvent.getX(), mouseEvent.getY());
        controller.ifEnterEdge(mouseEvent.getX(), mouseEvent.getY());
        testFrame.renderAllElements();
    }
}
