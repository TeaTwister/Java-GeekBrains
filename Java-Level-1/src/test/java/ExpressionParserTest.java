import homework_6.expression_parser.ExpressionParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionParserTest {

    @Test
    public void TestSimple() {
        assertEquals(0., ExpressionParser.parse("0").apply(), 0.);
        assertEquals(1., ExpressionParser.parse("1").apply(), 0.);
        assertEquals(-1., ExpressionParser.parse("-1").apply(), 0.);
        assertEquals(0.5, ExpressionParser.parse("0.5").apply(), 0.);
    }

    @Test
    public void TestExpression() {
        assertEquals(6., ExpressionParser.parse("3 + 3").apply(), 0.);
        assertEquals(0., ExpressionParser.parse("3 - 3").apply(), 0.);
        assertEquals(1., ExpressionParser.parse("3 / 3").apply(), 0.);
        assertEquals(9., ExpressionParser.parse("3 * 3").apply(), 0.);
    }

    @Test
    public void TestOrder() {
        assertEquals(1., ExpressionParser.parse("1 + 3 * 0").apply(), 0.);
        assertEquals(5., ExpressionParser.parse("2 * 5 - 5").apply(), 0.);
        assertEquals(6., ExpressionParser.parse("5 / 5 + 5").apply(), 0.);
        assertEquals(1., ExpressionParser.parse("2 - 2 / 2").apply(), 0.);
    }

    @Test
    public void TestNesting() {
        assertEquals(0., ExpressionParser.parse("(1 + 3) * 0").apply(), 0.);
        assertEquals(0., ExpressionParser.parse("2 * (5 - 5)").apply(), 0.);
        assertEquals(0.5, ExpressionParser.parse("5 / (5 + 5)").apply(), 0.);
        assertEquals(0., ExpressionParser.parse("(2 - 2) / 2").apply(), 0.);
    }

    @Test
    public void TestMultiNesting() {
        assertEquals(1., ExpressionParser.parse("2 - 1").apply(), 0.);
        assertEquals(2., ExpressionParser.parse("3 - (2 - 1)").apply(), 0.);
        assertEquals(-27., ExpressionParser
                .parse("-1 * (125 / (35 / 7) + 5 * (3 - (2 - 1)) / 5)").apply(), 0.);
        assertEquals(45., ExpressionParser
                .parse("1 + 2 * (125 / (35 / 7) + 5 - 5 * (3 - (2 - 1)) / 5) * -1 + 100").apply(), 0.);
    }
}
