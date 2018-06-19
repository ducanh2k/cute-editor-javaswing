package MyStack;

import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author THAYCACAC
 */
public class ManagerStack {

    MyStack<String> undo;
    MyStack<String> redo;
    JTextPane textPane;

    public ManagerStack(MyStack<String> undo, MyStack<String> redo, JTextPane textpane) {
        this.undo = undo;
        this.redo = redo;
        this.textPane = textpane;
    }

    //if content in text change then push to stack
    public void changeContent() {
        textPane.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent ce) {
                if (!textPane.getText().trim().isEmpty()
                        && !textPane.getText().equalsIgnoreCase(undo.top())) {
                    undo.push(textPane.getText());
                }
            }
        });
    }

    public void undo() {
        redo.push(undo.pop());
        textPane.setText(undo.top());
    }

    public void redo() {
        textPane.setText(redo.pop());
    }
}
