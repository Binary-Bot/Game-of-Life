import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.SimpleTestCase;
import org.hyperskill.hstest.testing.TestedProgram;

public class GameOfLifeTest extends StageTest<String> {

    SimpleTestCase[] testCases = {
            new SimpleTestCase(
                    "4 4 0",
                    "OOOO\n" +
                            "O O \n" +
                            "   O\n" +
                            "OOO "
            ),

            new SimpleTestCase(
                    "8 1 10",
                    " O  OO  \n" +
                            "OO   OO \n" +
                            "O     O \n" +
                            "        \n" +
                            "  O     \n" +
                            "  O O   \n" +
                            "     OO \n" +
                            "O   OO O"
            ),

            new SimpleTestCase(
                    "10 10 100",
                    "          \n" +
                            "          \n" +
                            "    O     \n" +
                            "   O O    \n" +
                            "    O     \n" +
                            "          \n" +
                            "          \n" +
                            "          \n" +
                            "          \n" +
                            "          "
            ),

            new SimpleTestCase(
                    "4 4 10",
                    "    \n" +
                            "    \n" +
                            "    \n" +
                            "    "
            ),

            new SimpleTestCase(
                    "32 -1 0",
                    "   OOO  O O    OOOOOO O O     OO\n" +
                            "   OO O    OO  O  O   O    O  OO\n" +
                            " O OOO OOO  OO  OO  O O  OO  O  \n" +
                            " O O O O    O     OO O    OO OOO\n" +
                            " O O O    O OOOOO OOOOOOOOO O OO\n" +
                            "O OOOO  O OOO OOOO O  O   OOO O \n" +
                            "O  OO  O  O     O O OOOOOOOOO O \n" +
                            "     OO OO  O OOO   OOOOO OOOOOO\n" +
                            "  O OO        O O    O     OOOO \n" +
                            "OOOO  OO  OO    O O   OO OOOO  O\n" +
                            "   O         O   O   OOOOOO    O\n" +
                            "   OOOOO   OOOOOOO  O O  O OO O \n" +
                            " O O  OOO O O O  OO OO   OO    O\n" +
                            "O    O OOOOO O    OO  OO O  OOO \n" +
                            " OOOOO   O O      O  O  O  OOOOO\n" +
                            "OOO O  OOOO OOO OO  O OO    OO  \n" +
                            "  OOO  OO  OO  O OOO     O O  OO\n" +
                            "OOO  OOOOOOO OOO  OO  O  O   OO \n" +
                            "OO O O    OOO    O O  O OOOO O  \n" +
                            "O O   OO  O     O  O O  O O O   \n" +
                            "OOO       OOOO OOO O    OOOO  OO\n" +
                            "O  OO  OOO     OOOO  O    O  O O\n" +
                            "  O OO  O OO  OOOOO  O   O OOO  \n" +
                            "O    OO O   O   OO O   O O OOOO \n" +
                            " O OOO O OOOOOO O   O O  O  OOO \n" +
                            " OO OOO  O O O  OO OOOOOOOOO  O \n" +
                            " OOO OO  OO O O   OO  OOOO OOO  \n" +
                            " O O O  O OOO O  OO OO   O    OO\n" +
                            "OO O O OOO OO O     OO  O  O O  \n" +
                            " O O O O OO     OOOOO O   O  OOO\n" +
                            "OOOOO     OO   O    O    OO    O\n" +
                            " OOO OO  O   O OO  OO   OO   O  "
            ),

            new SimpleTestCase(
                    "64 0 512",
                    "                                                        OO      \n" +
                            "                          OO                           O  O   O \n" +
                            "                         O  O                           OO    O \n" +
                            "                          O O                                 O \n" +
                            "             OO            O                                    \n" +
                            "             O O                           O                    \n" +
                            "              O                            O                    \n" +
                            "                                           O                    \n" +
                            "                 OO                                             \n" +
                            "                 OO                    OOO                      \n" +
                            "                                                                \n" +
                            "       OO                                  O                    \n" +
                            "       OO                                  O                    \n" +
                            "                                           O                    \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                                OO              \n" +
                            "                 O                              OO          O   \n" +
                            "                 O                                         O O  \n" +
                            "                 O                                         O  O \n" +
                            "                                                            OO  \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                      OO                        \n" +
                            "                                     O  O                       \n" +
                            "                                      O O                       \n" +
                            "                                       O                        \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                              O                                 \n" +
                            "                             O O                                \n" +
                            "                             OO                                 \n" +
                            "     OOO          O                                             \n" +
                            "                  O                    OO                       \n" +
                            "                  O                    OO                       \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                                                \n" +
                            "                                                     O          \n" +
                            "      OO                                            O O         \n" +
                            "      OO                     OO                     O O         \n" +
                            "                            O  O                     O          \n" +
                            "                             OO                                 \n" +
                            "          OO                                                    \n" +
                            "          OO                                                    \n" +
                            "                                                                \n" +
                            "                                            O                   \n" +
                            "                                  OO        O                   \n" +
                            "                                  OO    O   O                   \n" +
                            "                       OO               O                       \n" +
                            "                       OO               O                       \n" +
                            "                                                                \n" +
                            "                                                       OO       \n" +
                            "                                                O      OO       \n" +
                            "                                               O O              \n" +
                            "                                               O O              \n" +
                            "       OO                                       O               \n" +
                            "       OO                                                       \n" +
                            "                                                                \n" +
                            "                                                                "
            )

    };

    @DynamicTest(data = "testCases")
    CheckResult test(SimpleTestCase testCase) {

        TestedProgram program = new TestedProgram();
        program.start();

        String output = program.execute(testCase.getInput());

        if (!output.replace("\n", "").equals(testCase.getAttach().replace("\n", ""))) {
            return CheckResult.wrong("Your output is wrong!");
        }

        return CheckResult.correct();
    }
}
