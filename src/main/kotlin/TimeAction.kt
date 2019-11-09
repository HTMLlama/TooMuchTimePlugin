import com.intellij.ide.DataManager
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.ui.popup.JBPopupFactory

class TimeAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val actionGroup = ActionGroup.EMPTY_GROUP

        DataManager.getInstance().dataContextFromFocusAsync.onSuccess {
            it?.let {context ->
                val popupFactory = JBPopupFactory.getInstance()
                val actionPopup = popupFactory.createActionGroupPopup(
                    "You've spent a lot of time compiling!",
                    actionGroup,
                    context,
                    JBPopupFactory.ActionSelectionAid.ALPHA_NUMBERING,
                    true
                )

                actionPopup.show(popupFactory.guessBestPopupLocation(context))
            }
        }
    }
}