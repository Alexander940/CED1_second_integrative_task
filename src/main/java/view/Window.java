package view;

import model.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

public class Window {

    private int counterTemp = 0;
    private int maxNodes = 0;
    private int position = 0;

    private JButton startButton;
    private JPanel panel1;
    private JLabel numberNodesKey;
    private JTextField numberNodesValue;
    private JPanel panelInformation;
    private JPanel panelGraphManual;
    private JButton routes;
    private JButton dijkstra;
    private JPanel panelWelcome;
    private JButton graph_1;
    private JButton manualGraph;
    private JButton savedGraphButton;
    private JLabel title;
    private JButton isConnectedRandomGraph_DFS;
    private JPanel panelRandomGraph;
    private JButton shortestRouteDijkstraButton;
    private JButton showGraph;
    private JButton isConnectedDFSManualGraphButton;
    private JButton isConnectedDFSSavedGraphButton;
    private JButton shortestRouteDijkstraSavedGraphButton;
    private JPanel panelSavedGraph;
    private JButton showGraphButton;
    private JButton backButton;
    private JButton savedGraph2Button;
    private JPanel panelSavedGraph2;
    private JButton isAllStationsRelatedButtonSavedGraph2;
    private JButton isStationConnectToButtonSavedGraph2;
    private JButton shortestRouteDijkstraButtonSavedGraph2;
    private JButton showGraphButtonSavedGraph2;
    private JButton isAllStationsRelatedButtonSavedGraph;
    private JButton isStationsRelatedDFSButtonRandomGraph;
    private JButton isStationsRelatedDFSButtonManualGraph;

    private Graph graph;

    public Window() {

        $$$setupUI$$$();
        panelWelcome.setVisible(true);
        routes.setVisible(false);
        dijkstra.setVisible(false);
        panelInformation.setVisible(false);
        panelGraphManual.setVisible(false);
        panelRandomGraph.setVisible(false);
        panelSavedGraph.setVisible(false);
        isConnectedRandomGraph_DFS.setVisible(false);
        shortestRouteDijkstraButton.setVisible(false);
        showGraph.setVisible(false);
        isConnectedDFSManualGraphButton.setVisible(false);
        isConnectedDFSSavedGraphButton.setVisible(false);
        shortestRouteDijkstraSavedGraphButton.setVisible(false);
        showGraphButton.setVisible(false);
        backButton.setVisible(false);
        panelSavedGraph2.setVisible(false);
        isAllStationsRelatedButtonSavedGraph2.setVisible(false);
        isStationConnectToButtonSavedGraph2.setVisible(false);
        shortestRouteDijkstraButtonSavedGraph2.setVisible(false);
        showGraphButtonSavedGraph2.setVisible(false);
        isAllStationsRelatedButtonSavedGraph.setVisible(false);
        isStationsRelatedDFSButtonRandomGraph.setVisible(false);
        isStationsRelatedDFSButtonManualGraph.setVisible(false);


        this.handleEventButtonManualGraph();
        this.handleEventButtonStart();
        this.handleEventButtonRoute();
        this.handleEventButtonDijkstra();
        this.handleEventPrintNode();
        this.handleEventButtonGraph1();
        this.handleEventButtonOpenSavedGraph();
        this.handleEventButtonShowGraph();
        this.handleEventButtonCalculateDijkstraRandomGraph();
        this.handleEventButtonCalculateDFSRandomGraph();
        this.handleEventButtonCalculateDFSManualGraph();
        this.handleEventButtonShowSavedGraph();
        this.handleEventButtonCalculateDijkstraSavedGraph();
        this.handleEventButtonCalculateDijkstraSavedGraph2();
        this.handleEventButtonCalculateDFSSavedGraph();
        this.handleEventButtonBack();
        this.handleEventOpenSavedGraph2();
        this.handleEventShowSavedGraph2();
        this.handleEventButtonCalculateDFSRelatedRandomGraph();
        this.handleEventButtonCalculateDFSSavedGraph2();
        this.handleEventButtonCalculateDFSRelatedSavedGraph2();
        this.handleEventButtonCalculateDFSRelatedSavedGraph();
        this.handleEventButtonCalculateDFSRelatedManualGraph();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Window");
        frame.setContentPane(new Window().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void handleEventButtonManualGraph() {
        manualGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInformation.setVisible(true);
                panelWelcome.setVisible(false);
            }
        });
    }

    private void handleEventButtonOpenSavedGraph() {
        savedGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSavedGraph.setVisible(true);
                isConnectedDFSSavedGraphButton.setVisible(true);
                shortestRouteDijkstraSavedGraphButton.setVisible(true);
                showGraphButton.setVisible(true);
                backButton.setVisible(true);
                isAllStationsRelatedButtonSavedGraph.setVisible(true);
                panelWelcome.setVisible(false);
            }
        });
    }

    private void handleEventButtonBack() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelWelcome.setVisible(true);
                routes.setVisible(false);
                dijkstra.setVisible(false);
                panelInformation.setVisible(false);
                panelGraphManual.setVisible(false);
                panelRandomGraph.setVisible(false);
                panelSavedGraph.setVisible(false);
                isConnectedRandomGraph_DFS.setVisible(false);
                shortestRouteDijkstraButton.setVisible(false);
                showGraph.setVisible(false);
                isConnectedDFSManualGraphButton.setVisible(false);
                isConnectedDFSSavedGraphButton.setVisible(false);
                shortestRouteDijkstraSavedGraphButton.setVisible(false);
                showGraphButton.setVisible(false);
                backButton.setVisible(false);
                panelSavedGraph2.setVisible(false);
                isAllStationsRelatedButtonSavedGraph2.setVisible(false);
                isStationConnectToButtonSavedGraph2.setVisible(false);
                shortestRouteDijkstraButtonSavedGraph2.setVisible(false);
                showGraphButtonSavedGraph2.setVisible(false);
                isStationsRelatedDFSButtonManualGraph.setVisible(false);
                isAllStationsRelatedButtonSavedGraph.setVisible(false);
                isStationsRelatedDFSButtonRandomGraph.setVisible(false);
                TrainStation.getInstance().resetGraph();
                graph = null;
                counterTemp = 0;
                position = 0;
            }
        });
    }

    private void handleEventButtonShowSavedGraph() {
        showGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainStation.getInstance().initializeGraph(50);
                TrainStation.getInstance().generateSavedGraph(panelSavedGraph.getGraphics());
                showGraphButton.setVisible(false);
            }
        });
    }

    private void handleEventButtonGraph1() {
        graph_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRandomGraph.setVisible(true);
                isConnectedRandomGraph_DFS.setVisible(true);
                shortestRouteDijkstraButton.setVisible(true);
                showGraph.setVisible(true);
                backButton.setVisible(true);
                isStationsRelatedDFSButtonRandomGraph.setVisible(true);
                panelWelcome.setVisible(false);
            }
        });
    }

    private void handleEventButtonShowGraph() {
        showGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainStation.getInstance().generateRandomGraph(panelRandomGraph.getGraphics());
            }
        });
    }

    private void handleEventButtonCalculateDijkstraRandomGraph() {
        shortestRouteDijkstraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(firstNodeSelected.getText()) || !TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                TrainStation.getInstance().calculateDijkstra(panelRandomGraph, firstNodeSelected.getText(), secondNodeSelected.getText());
            }
        });
    }

    private void handleEventButtonCalculateDijkstraSavedGraph() {
        shortestRouteDijkstraSavedGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(firstNodeSelected.getText()) || !TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                TrainStation.getInstance().calculateDijkstra(panelSavedGraph, firstNodeSelected.getText(), secondNodeSelected.getText());
            }
        });
    }

    private void handleEventButtonCalculateDijkstraSavedGraph2() {
        shortestRouteDijkstraButtonSavedGraph2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(firstNodeSelected.getText()) || !TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                TrainStation.getInstance().calculateDijkstra(panelSavedGraph2, firstNodeSelected.getText(), secondNodeSelected.getText());
            }
        });
    }

    private void handleEventButtonCalculateDFSRandomGraph() {
        isConnectedRandomGraph_DFS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(firstNodeSelected.getText()) || !TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                if (TrainStation.getInstance().calculateDFS(TrainStation.getInstance().getGraph(), firstNodeSelected.getText(), secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "It's connected");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't connected");
                }
            }
        });
    }

    private void handleEventButtonCalculateDFSSavedGraph() {
        isConnectedDFSSavedGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(firstNodeSelected.getText()) || !TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                if (TrainStation.getInstance().calculateDFS(TrainStation.getInstance().getGraph(), firstNodeSelected.getText(), secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "It's connected");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't connected");
                }
            }
        });
    }

    private void handleEventButtonCalculateDFSSavedGraph2() {
        isStationConnectToButtonSavedGraph2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(firstNodeSelected.getText()) || !TrainStation.getInstance().getGraph().checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                if (TrainStation.getInstance().calculateDFS(TrainStation.getInstance().getGraph(), firstNodeSelected.getText(), secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "It's connected");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't connected");
                }
            }
        });
    }

    private void handleEventButtonCalculateDFSRelatedSavedGraph2() {
        isAllStationsRelatedButtonSavedGraph2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TrainStation.getInstance().calculateDFSRelated(TrainStation.getInstance().getGraph())) {
                    JOptionPane.showMessageDialog(null, "It's related");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't related");
                }
            }
        });
    }

    private void handleEventButtonCalculateDFSRelatedSavedGraph() {
        isAllStationsRelatedButtonSavedGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TrainStation.getInstance().calculateDFSRelated(TrainStation.getInstance().getGraph())) {
                    JOptionPane.showMessageDialog(null, "It's related");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't related");
                }
            }
        });
    }

    private void handleEventButtonCalculateDFSRelatedRandomGraph() {
        isStationsRelatedDFSButtonRandomGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TrainStation.getInstance().calculateDFSRelated(TrainStation.getInstance().getGraph())) {
                    JOptionPane.showMessageDialog(null, "It's related");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't related");
                }
            }
        });
    }

    private void handleEventButtonCalculateDFSRelatedManualGraph() {
        isStationsRelatedDFSButtonManualGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DFS dfs = new DFS(graph);
                if (dfs.dfsAllRelated()) {
                    JOptionPane.showMessageDialog(null, "It's related");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't related");
                }
            }
        });
    }

    private void handleEventButtonCalculateDFSManualGraph() {
        isConnectedDFSManualGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!graph.checkIfNameAlreadyExist(firstNodeSelected.getText()) || !graph.checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                DFS dfs = new DFS(graph, firstNodeSelected.getText(), secondNodeSelected.getText());

                if (dfs.dfsNodeToNode()) {
                    JOptionPane.showMessageDialog(null, "It's connected");
                } else {
                    JOptionPane.showMessageDialog(null, "It isn't connected");
                }
            }
        });
    }

    private void handleEventButtonStart() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numberNodes = Integer.parseInt(numberNodesValue.getText());

                if (numberNodes <= 1) {
                    JOptionPane.showMessageDialog(null, "The number of nodes must be greater than 1");
                    return;
                }

                maxNodes = numberNodes;
                graph = new Graph(numberNodes);
                panelInformation.setVisible(false);
                panelGraphManual.setVisible(true);
                routes.setVisible(true);
                dijkstra.setVisible(true);
                isConnectedDFSManualGraphButton.setVisible(true);
                isStationsRelatedDFSButtonManualGraph.setVisible(true);
                backButton.setVisible(true);
            }
        });
    }

    private void handleEventButtonRoute() {
        routes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (maxNodes > counterTemp) {
                    JOptionPane.showMessageDialog(null, "First, you must finish of creating all nodes");
                    return;
                }

                createAdjacency(graph, panelGraphManual);
            }
        });
    }

    private void handleEventButtonDijkstra() {
        dijkstra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField firstNodeSelected = new JTextField();
                JTextField secondNodeSelected = new JTextField();

                Object[] fields = {
                        "initial node ", firstNodeSelected,
                        "final node", secondNodeSelected
                };

                int option = JOptionPane.showConfirmDialog(null, fields, "Enter adjacency weight between node", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.CANCEL_OPTION) return;

                if (!graph.checkIfNameAlreadyExist(firstNodeSelected.getText()) || !graph.checkIfNameAlreadyExist(secondNodeSelected.getText())) {
                    JOptionPane.showMessageDialog(null, "Node that you entered it is invalid or doesn't exist");
                    return;
                }

                int positionNode1 = graph.returnPosition(firstNodeSelected.getText());
                int positionNode2 = graph.returnPosition(secondNodeSelected.getText());
                Dijkstra dijkstra = new Dijkstra(graph, maxNodes, positionNode1, positionNode2, firstNodeSelected.getText(), secondNodeSelected.getText());
                dijkstra.dijkstra(panelGraphManual);
            }
        });
    }

    private void handleEventPrintNode() {
        panelGraphManual.addMouseListener(new MouseAdapter() {
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
                    System.out.print(positionX);
                    System.out.print("-");
                    System.out.print(positionY);
                    System.out.print(";");
                    graph.setNameNodes(position, nameNode);
                    Pinter.printNodeInGraph(panelGraphManual.getGraphics(), positionX, positionY, nameNode);
                    position++;
                }

            }
        });
    }

    private void handleEventOpenSavedGraph2() {
        savedGraph2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelSavedGraph2.setVisible(true);
                isAllStationsRelatedButtonSavedGraph2.setVisible(true);
                isStationConnectToButtonSavedGraph2.setVisible(true);
                shortestRouteDijkstraButtonSavedGraph2.setVisible(true);
                showGraphButtonSavedGraph2.setVisible(true);
                backButton.setVisible(true);
                panelWelcome.setVisible(false);
            }
        });
    }

    private void handleEventShowSavedGraph2() {
        showGraphButtonSavedGraph2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainStation.getInstance().generateSavedGraph2(panelSavedGraph2.getGraphics());
                showGraphButtonSavedGraph2.setVisible(false);
            }
        });
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
                "from (Node Name)", firstNodeSelected,
                "to (Node Name)", secondNodeSelected,
                "weight", weightAdjacency
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Enter Adjacency Weight between node", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.CANCEL_OPTION) return;

        if (!graph.checkIfNameAlreadyExist(firstNodeSelected.getText()) || !graph.checkIfNameAlreadyExist(secondNodeSelected.getText())) {
            JOptionPane.showMessageDialog(null, "A node that you entered is invalid or doesn't exist");
            return;
        }

        int positionNode1 = graph.returnPosition(firstNodeSelected.getText());
        int positionNode2 = graph.returnPosition(secondNodeSelected.getText());

        if (graph.getMatrixAdjacency(positionNode1, positionNode2) == 1) {
            JOptionPane.showMessageDialog(null, "These nodes already have an assigned adjacency between them");
        }

        int weight = Integer.parseInt(weightAdjacency.getText());
        graph.setMatrixCoefficient(positionNode1, positionNode2, weight);
        graph.setMatrixAdjacency(positionNode1, positionNode2, 1);
        Pinter.printEdge(pinterGraph.getGraphics(), graph.getCoordinatesX(positionNode1), graph.getCoordinatesY(positionNode1), graph.getCoordinatesX(positionNode2), graph.getCoordinatesY(positionNode2), weight);
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
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelInformation = new JPanel();
        panelInformation.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panelInformation, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        numberNodesKey = new JLabel();
        numberNodesKey.setText("Number Nodes: ");
        panelInformation.add(numberNodesKey, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setEnabled(true);
        startButton.setHideActionText(false);
        startButton.setText("Start");
        panelInformation.add(startButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numberNodesValue = new JTextField();
        numberNodesValue.setText("");
        panelInformation.add(numberNodesValue, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        panelGraphManual = new JPanel();
        panelGraphManual.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panelGraphManual, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        dijkstra = new JButton();
        dijkstra.setText("Shortest Route (Dijkstra)");
        panelGraphManual.add(dijkstra, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelGraphManual.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        routes = new JButton();
        routes.setText("Create Routes");
        panelGraphManual.add(routes, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        isConnectedDFSManualGraphButton = new JButton();
        isConnectedDFSManualGraphButton.setText("Station To Station (DFS)");
        panelGraphManual.add(isConnectedDFSManualGraphButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        isStationsRelatedDFSButtonManualGraph = new JButton();
        isStationsRelatedDFSButtonManualGraph.setText("Is Stations Related? (DFS)");
        panelGraphManual.add(isStationsRelatedDFSButtonManualGraph, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelWelcome = new JPanel();
        panelWelcome.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panelWelcome, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        graph_1 = new JButton();
        graph_1.setText("Random Graph");
        panelWelcome.add(graph_1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        manualGraph = new JButton();
        manualGraph.setText("Manual Graph");
        panelWelcome.add(manualGraph, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        savedGraphButton = new JButton();
        savedGraphButton.setText("Saved Graph");
        panelWelcome.add(savedGraphButton, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        title = new JLabel();
        Font titleFont = this.$$$getFont$$$("Arial Black", Font.BOLD, 26, title.getFont());
        if (titleFont != null) title.setFont(titleFont);
        title.setText("!Welcome to the train station¡");
        panelWelcome.add(title, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        savedGraph2Button = new JButton();
        savedGraph2Button.setText("Saved Graph 2");
        panelWelcome.add(savedGraph2Button, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelRandomGraph = new JPanel();
        panelRandomGraph.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panelRandomGraph, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        isConnectedRandomGraph_DFS = new JButton();
        isConnectedRandomGraph_DFS.setText("Station To Station (DFS)");
        panelRandomGraph.add(isConnectedRandomGraph_DFS, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelRandomGraph.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        shortestRouteDijkstraButton = new JButton();
        shortestRouteDijkstraButton.setText("Shortest route (Dijkstra)");
        panelRandomGraph.add(shortestRouteDijkstraButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showGraph = new JButton();
        showGraph.setText("Show graph");
        panelRandomGraph.add(showGraph, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        isStationsRelatedDFSButtonRandomGraph = new JButton();
        isStationsRelatedDFSButtonRandomGraph.setText("Is Stations Related? (DFS)");
        panelRandomGraph.add(isStationsRelatedDFSButtonRandomGraph, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelSavedGraph = new JPanel();
        panelSavedGraph.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panelSavedGraph, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        isConnectedDFSSavedGraphButton = new JButton();
        isConnectedDFSSavedGraphButton.setText("Is Connected (DFS)");
        panelSavedGraph.add(isConnectedDFSSavedGraphButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panelSavedGraph.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        shortestRouteDijkstraSavedGraphButton = new JButton();
        shortestRouteDijkstraSavedGraphButton.setText("Shortest Route (Dijkstra)");
        panelSavedGraph.add(shortestRouteDijkstraSavedGraphButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showGraphButton = new JButton();
        showGraphButton.setText("Show Graph");
        panelSavedGraph.add(showGraphButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        isAllStationsRelatedButtonSavedGraph = new JButton();
        isAllStationsRelatedButtonSavedGraph.setText("Is Stations Related? (DFS)");
        panelSavedGraph.add(isAllStationsRelatedButtonSavedGraph, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Back");
        panel1.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelSavedGraph2 = new JPanel();
        panelSavedGraph2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panelSavedGraph2, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        isAllStationsRelatedButtonSavedGraph2 = new JButton();
        isAllStationsRelatedButtonSavedGraph2.setText("Is Stations Related? (DFS)");
        panelSavedGraph2.add(isAllStationsRelatedButtonSavedGraph2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panelSavedGraph2.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        isStationConnectToButtonSavedGraph2 = new JButton();
        isStationConnectToButtonSavedGraph2.setText("Station To Station (DFS)");
        panelSavedGraph2.add(isStationConnectToButtonSavedGraph2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        shortestRouteDijkstraButtonSavedGraph2 = new JButton();
        shortestRouteDijkstraButtonSavedGraph2.setText("Shortest Route (Dijkstra)");
        panelSavedGraph2.add(shortestRouteDijkstraButtonSavedGraph2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        showGraphButtonSavedGraph2 = new JButton();
        showGraphButtonSavedGraph2.setText("Show Graph");
        panelSavedGraph2.add(showGraphButtonSavedGraph2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
