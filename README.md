# **CUTE EDITOR**

### **Introduction**
This document provides an overview of the a text editor, it had been used learned knowledge in CSD201 as ArrayList, LinkedList, Stack, ...

### **Information**
Project name: Cute Editor
Project type:	Java Application
Author:	Pham Ngoc Hoa
Timeline:  From June 15th, 2018 to June 20th, 2018
The project incluce:
•	6 package: Guide, Design, Icon, LinkList, MyCustom and MyStack with map
•	22 class 
•	41 image

### **Function**
- **New File**
- **Open File**
- **Save File**
- **Save As File**
- **Zip File**
- **Setting**
- **Close File**
- **Copy, Past, Delete**
- **Bold, Italic, Underline**
- **Find**
- **Replace**
- **Undo/ Redo**
### **Undo redo use Stack**
```java
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
```
** Thaycacac@gmail.com*