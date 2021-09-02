//package duke;
//import duke.command.Command;
//import duke.command.CommandTypes;
//import org.junit.Test;
//import org.junit.Assert;
//
//public class CommandTest {
//    @Test
//    public void isExitTest_commandBye_true() {
//        Assert.assertTrue(new Command(CommandTypes.BYE, "").isExit());
//    }
//
//    @Test
//    public void isExitTest_commandDeadline_false() {
//        Assert.assertFalse(new Command(CommandTypes.DEADLINE, "").isExit());
//    }
//
//    @Test
//    public void isExitTest_commandDelete_false() {
//        Assert.assertFalse(new Command(CommandTypes.DELETE, "").isExit());
//    }
//
//    @Test
//    public void isExitTest_commandDone_false() {
//        Assert.assertFalse(new Command(CommandTypes.DONE, "").isExit());
//    }
//
//    @Test
//    public void isExitTest_commandEvent_false() {
//        Assert.assertFalse(new Command(CommandTypes.EVENT, "").isExit());
//    }
//
//    @Test
//    public void isExitTest_commandList_false() {
//        Assert.assertFalse(new Command(CommandTypes.LIST, "").isExit());
//    }
//
//    @Test
//    public void isExitTest_commandTodo_false() {
//        Assert.assertFalse(new Command(CommandTypes.TODO, "").isExit());
//    }
//
//    @Test
//    public void isExitTest_commandUnknown_false() {
//        Assert.assertFalse(new Command(CommandTypes.UNKNOWN, "").isExit());
//    }
//}