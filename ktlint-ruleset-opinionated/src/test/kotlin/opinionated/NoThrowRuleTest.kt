package opinionated

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class NoThrowRuleTest : Spek({

    describe("no-throw rule") {

        // whenever KTLINT_DEBUG env variable is set to "ast" or -DktlintDebug=ast is used
        // com.pinterest.ktlint.test.(lint|format) will print AST (along with other debug info) to the stderr.
        // this can be extremely helpful while writing and testing rules.
        // uncomment the line below to take a quick look at it
        // System.setProperty("ktlintDebug", "ast")

        val rule = NoThrowRule()

        it("should prohibit usage of throw") {
            assertThat(rule.lint(
                """fun fn() { throw Exception() } """.trimMargin()))
                .isEqualTo(listOf(LintError(1, 12, "no-throw", "Unexpected throw, use a sealed interface instead")))
        }
    }
})
