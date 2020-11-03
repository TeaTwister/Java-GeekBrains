package homework_6.expression_parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    static final Pattern VALUES = Pattern.compile("-?[0-9.]+");
    static final Pattern SIGNS = Pattern.compile("[+\\-*/] ");
    static final Pattern FLAT = Pattern.compile("[0-9.]+.*[0-9.]+|[0-9.]+");

    public static Expression parse(String input) {
        ArrayList<Expression> args = new ArrayList<>();
        ArrayList<Operation> ops = new ArrayList<>();
        Matcher m;
        boolean hasInner = input.contains("(");
        if (hasInner) {
            int end = input.indexOf("(");
            String innerStr = findInner(input);
            args.addAll(Arrays.asList(findArgs(input.substring(0, end))));
            ops.addAll(Arrays.asList(findOps(input.substring(0, end))));
            args.add(parse(innerStr));
            String rightStr = input.substring(end + innerStr.length() + 2);
            if (rightStr.contains("(")) {
                m = SIGNS.matcher(rightStr);
                if (m.find()) {
                    ops.add(getOperation(m.group()));
                    args.add(parse(m.replaceFirst("")));
                }
            } else {
                args.addAll(Arrays.asList(findArgs(rightStr)));
                ops.addAll(Arrays.asList(findOps(rightStr)));
            }
            return new Flat(args.toArray(new Expression[0]), ops.toArray(new Operation[0]));
        }
        return parseFlat(input);
    }

    private static String findInner(String input) {
        int start = input.indexOf("(") + 1;
        int length = findLevel(input.substring(start));
        return input.substring(start, start + length);
    }

    private static int findLevel(String input) {
        int level = 1;
        int i;
        for (i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') level++;
            if (input.charAt(i) == ')') level--;
            if (level == 0) break;
        }
        return i;
    }

    private static Flat parseFlat(String input) {
        return new Flat(findArgs(input), findOps(input));
    }

    private static Constant[] findArgs(String input) {
        Matcher matcher = VALUES.matcher(input);
        ArrayList<Constant> args = new ArrayList<>();
        while (matcher.find()) args.add(new Constant(Double.parseDouble(matcher.group())));
        return args.toArray(new Constant[0]);
    }

    private static Operation[] findOps(String input) {
        Matcher matcher = SIGNS.matcher(input);
        ArrayList<Operation> ops = new ArrayList<>();
        while (matcher.find()) ops.add(getOperation(matcher.group().trim()));
        return ops.toArray(new Operation[0]);
    }

    private static Operation getOperation(String s) {
        return switch (s.trim()) {
            case "+" -> Operation.ADD;
            case "-" -> Operation.SUBTRACT;
            case "*" -> Operation.MULTIPLY;
            case "/" -> Operation.DIVIDE;
            default -> null;
        };
    }
}
