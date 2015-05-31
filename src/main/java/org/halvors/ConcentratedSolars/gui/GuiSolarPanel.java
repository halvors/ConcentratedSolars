package org.halvors.ConcentratedSolars.gui;

public class GuiSolarPanel extends Gui {
    public GuiSolarPanel() {
        super("guiSolarPanel");

        add(new Button("testbutton2", "I'm EAST")
                .setMaximumSize(Integer.MAX_VALUE, 120)
                .onEvent((event, component) -> {
                    System.out.println("Test button pressed! " + Side.get());
                }, ActionEvent.class, Side.BOTH), Anchor.EAST);

        add(new Button("testbutton3", "I'm CENTER"))
                .add(new Container("test").setLayout(new FlowLayout())
                        .add(new Slot("main", 0))
                        .add(new Slot("main", 0))
                        .add(new Slot("main", 0))
                        .add(new Slot("main", 0)), Anchor.SOUTH)
                .add(new Container("container").setLayout(new FlowLayout())
                        .add(new Button("testbutton5", "I'm the FIRST Button and need lots of space"))
                        .add(new Label("testlabel1", "I'm some label hanging around").setBackground(new Background(Color.white)))
                        .add(new Button("testbutton7", "I'm THIRD"))
                        .add(new Button("testbutton8", "I'm FOURTH")), Anchor.NORTH)
                .onGuiEvent((event) -> {
                    event.gui.addInventory("main", ((BlockSimpleTest)event.block.get()).inventory);
                    System.out.println("Test GUI initialized! " + event.player.getDisplayName() + " " + event.position);
                }, BindEvent.class)
                .onGuiEvent((event) -> {
                    System.out.println("Test GUI closed!");
                }, UnBindEvent.class);
    }
}