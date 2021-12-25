package opinionated

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.ElementType.OPEN_KEYWORD
import com.pinterest.ktlint.core.ast.ElementType.THROW_KEYWORD
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

class NoThrowRule : Rule("no-throw") {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == THROW_KEYWORD) {
            emit(node.startOffset, "Unexpected throw, use a sealed interface instead", false)
        }
    }
}
