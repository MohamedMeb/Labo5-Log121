package command;

import java.util.Stack;

public class CommandManager {
    private CommandManager commandManager;
    private Stack<AbstractAction> undoStack = new Stack<>();
    private Stack<AbstractAction> redoStack = new Stack<>();

    private CommandManager(){
        commandManager = new CommandManager();
    }
    public static CommandManager getInstance(){
        return new CommandManager();
    }

    public void executeCommand(AbstractAction action){
        action.execute();
        undoStack.push(action);
        redoStack.clear();
    }

    public void undo(){
        AbstractAction action = undoStack.pop();
        action.undo();
        redoStack.push(action);
    }

    public void redo(){
        AbstractAction action = redoStack.pop();
        action.execute();
        undoStack.push(action);
    }
}
