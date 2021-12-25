package opinionated

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.ElementType.OPEN_KEYWORD
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

class NoOpenRule : Rule("no-open") {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == OPEN_KEYWORD) {
            emit(node.startOffset, "Unexpected open", false)
        }
    }
}
