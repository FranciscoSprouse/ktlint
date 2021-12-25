package opinionated

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class NoDoubleBangRuleTest : Spek({

    describe("no-double-bang rule") {

        // whenever KTLINT_DEBUG env variable is set to "ast" or -DktlintDebug=ast is used
        // com.pinterest.ktlint.test.(lint|format) will print AST (along with other debug info) to the stderr.
        // this can be extremely helpful while writing and testing rules.
        // uncomment the line below to take a quick look at it
        // System.setProperty("ktlintDebug", "ast")

        val rule = NoDoubleBangRule()

        it("should prohibit usage of !!") {
            assertThat(rule.lint("""
                |fun fn() {
                |    var v: String? = null
                |    val x = v!!
                |}""".trimMargin()))
                .isEqualTo(listOf(LintError(3, 14, "no-double-bang", "Unexpected !!")))
        }
    }
})
