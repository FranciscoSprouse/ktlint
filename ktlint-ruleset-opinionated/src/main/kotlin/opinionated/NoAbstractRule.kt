package opinionated

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.ElementType.ABSTRACT_KEYWORD
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

class NoAbstractRule : Rule("no-abstract") {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == ABSTRACT_KEYWORD) {
            emit(node.startOffset, "Unexpected abstract", false)
        }
    }
}
