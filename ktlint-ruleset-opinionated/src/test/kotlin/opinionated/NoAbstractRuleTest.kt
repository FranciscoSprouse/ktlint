package opinionated

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class NoAbstractRuleTest : Spek({

    describe("no-abstract rule") {

        // whenever KTLINT_DEBUG env variable is set to "ast" or -DktlintDebug=ast is used
        // com.pinterest.ktlint.test.(lint|format) will print AST (along with other debug info) to the stderr.
        // this can be extremely helpful while writing and testing rules.
        // uncomment the line below to take a quick look at it
        // System.setProperty("ktlintDebug", "ast")

        val rule = NoAbstractRule()

        it("should prohibit usage of abstract") {
            assertThat(rule.lint("""abstract class MyClass { }"""))
                .isEqualTo(listOf(LintError(1, 1, "no-abstract", "Unexpected abstract")))
        }
    }
})
