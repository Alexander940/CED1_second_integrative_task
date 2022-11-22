package view;

import model.Dijkstra;
import model.Graph;
import model.Pinter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window {

    private int currentNumberNode = 0;
    private int counterTemp = 0;
    private int endNode;
    private int permanentNode;
    private int maxNodes = 0;
    private int position = 0;
    private int numberClicks = 0;
    private int nodeSelected1 = 0;
    private int getNodeSelected2 = 0;

    private JButton startButton;
    private JPanel panel1;
    private JLabel numberNodesKey;
    private JTextField numberNodesValue;
    private JPanel getInformation;
    private JPanel pinterGraph;
    private JButton routes;
    private JButton dijkstra;
    private JButton randomGraph;

    private Graph graph;

    public Window() {

        routes.setVisible(false);
        dijkstra.setVisible(false);
        randomGraph.setVisible(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numberNodes = Integer.parseInt(numberNodesValue.getText());
                maxNodes = numberNodes;
                graph = new Graph(numberNodes);
                getInformation.setVisible(false);
                pinterGraph.setVisible(true);
                routes.setVisible(true);
                dijkstra.setVisible(true);
                randomGraph.setVisible(true);
            }
        });

        routes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (maxNodes > counterTemp) {
                    JOptionPane.showMessageDialog(null, "First, you must finish of creating all nodes");
                    return;
                }

                randomGraph.setEnabled(false);
                createAdjacency(graph, pinterGraph);
            }
        });

        dijkstra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter Adjacency Weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION && graph.checkIfNameAlreadyExist(firstNodeSelected.getText()) && graph.checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    int positionNode1 = graph.returnPosition(firstNodeSelected.getText());
                    int positionNode2 = graph.returnPosition(secondNodeSelected.getText());

                    Dijkstra dijkstra = new Dijkstra(graph, maxNodes, positionNode1, positionNode2, firstNodeSelected.getText(), secondNodeSelected.getText());
                    dijkstra.dijkstra(pinterGraph);
                } else {
                    JOptionPane.showMessageDialog(null, "A node that you entered it is invalid or doesn't exist");
                }
            }
        });

        randomGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routes.setEnabled(false);
            }
        });

        pinterGraph.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                counterTemp = counterTemp + e.getClickCount();
                int positionX = e.getX();
                int positionY = e.getY();

                if (maxNodes >= counterTemp) {
                    String nameNode = assignNameNode(graph);

                    graph.setCoordinatesX(position, positionX);
                    graph.setCoordinatesY(position, positionY);
                    graph.setNameNodes(position, nameNode);
                    Pinter.printNodeInGraph(pinterGraph.getGraphics(), positionX, positionY, nameNode);
                    position++;
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Window");
        frame.setContentPane(new Window().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static String assignNameNode(final Graph graph) {
        String nameNode = null;

        while (nameNode == null) {
            nameNode = JOptionPane.showInputDialog("Enter name Node");

            if (nameNode != null && nameNode.equals("")) {
                JOptionPane.showMessageDialog(null, "The name can not be empty");
                nameNode = null;
            } else if (nameNode != null && graph.checkIfNameAlreadyExist(nameNode)) {
                JOptionPane.showMessageDialog(null, "This name already exist");
                nameNode = null;
            }
        }

        return nameNode;
    }

    private static void createAdjacency(final Graph graph, final JPanel pinterGraph) {
        JTextField firstNodeSelected = new JTextField();
        JTextField secondNodeSelected = new JTextField();
        JTextField weightAdjacency = new JTextField();

        Object[] fields = {
                "node1", firstNodeSelected,
                "node2", secondNodeSelected,
                "weight", weightAdjacency
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Enter Adjacency Weight between node", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION && graph.checkIfNameAlreadyExist(firstNodeSelected.getText()) && graph.checkIfNameAlreadyExist(secondNodeSelected.getText())) {
            int positionNode1 = graph.returnPosition(firstNodeSelected.getText());
            int positionNode2 = graph.returnPosition(secondNodeSelected.getText());

            int weight = Integer.parseInt(weightAdjacency.getText());
            graph.setMatrixCoefficient(positionNode1, positionNode2, weight);
            graph.setMatrixAdjacency(positionNode1, positionNode2, 1);
            Pinter.printEdge(pinterGraph.getGraphics(), graph.getCoordinatesX(positionNode1), graph.getCoordinatesY(positionNode1), graph.getCoordinatesX(positionNode2), graph.getCoordinatesY(positionNode2), weight);
        } else {
            JOptionPane.showMessageDialog(null, "A node that you entered it is invalid or doesn't exist");
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        getInformation = new JPanel();
        getInformation.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(getInformation, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        numberNodesKey = new JLabel();
        numberNodesKey.setText("Number Nodes: ");
        getInformation.add(numberNodesKey, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setEnabled(true);
        startButton.setHideActionText(false);
        startButton.setText("Start");
        getInformation.add(startButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numberNodesValue = new JTextField();
        numberNodesValue.setText("");
        getInformation.add(numberNodesValue, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pinterGraph = new JPanel();
        pinterGraph.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(pinterGraph, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        dijkstra = new JButton();
        dijkstra.setText("Calculate Dijkstra");
        pinterGraph.add(dijkstra, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        pinterGraph.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        randomGraph = new JButton();
        randomGraph.setText("Random Graph");
        pinterGraph.add(randomGraph, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        routes = new JButton();
        routes.setText("Create Routes");
        pinterGraph.add(routes, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
