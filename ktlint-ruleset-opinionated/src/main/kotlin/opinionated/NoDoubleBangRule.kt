package opinionated

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.ElementType.ABSTRACT_KEYWORD
import com.pinterest.ktlint.core.ast.ElementType.EXCLEXCL
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

class NoDoubleBangRule : Rule("no-double-bang") {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == EXCLEXCL) {
            emit(node.startOffset, "Unexpected !!", false)
        }
    }
}
