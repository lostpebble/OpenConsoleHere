package com.paulmyburgh.openconsolehere.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

public class ActionOpenInConsole extends AnAction {

    public void actionPerformed(AnActionEvent e) {

        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);

        if (openInTerminalSettingsState != null) {
            try {
                Runtime.getRuntime().exec(openTerminalCmd);
            } catch (IOException e1) {
                notifyAboutIncorrectOptions(openInTerminalSettingsState);
            }
        } else {
            notifyAboutUnsetOptions();
        }
    }
}
