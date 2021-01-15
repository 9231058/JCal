package jcalc;

import java.util.Stack;
import java.util.concurrent.ExecutionException;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import jcalc.tokenizer.Token;
import jcalc.tokenizer.TokenType;
import jcalc.tokenizer.Tokeninzer;

public class TokenMannager extends SwingWorker<Double, Object> {

	private String toCalculate;
	private JTextField textField;
	private Stack<Token> tokenStack = new Stack<>();
	private Stack<Double> valueStack = new Stack<>();

	public TokenMannager(String toCalculate, JTextField textField) {
		super();
		this.toCalculate = toCalculate;
		this.textField = textField;
	}

	@Override
	protected Double doInBackground() throws Exception {
		Tokeninzer tokeninzer = new Tokeninzer(toCalculate);
		while (true) {
			Token token = tokeninzer.getToken();
			if (token.getTokenType() == TokenType.EOF
					|| token.getTokenType() == TokenType.EOL) {
				break;
			} else if (token.getTokenType() == TokenType.VALUE) {
				valueStack.add(token.getValue());
			} else {
				addTokenToStack(token);
			}
		}
		while (!tokenStack.isEmpty()) {
			Token token = tokenStack.pop();
			Double value1 = valueStack.pop();
			Double value2 = valueStack.pop();
			valueStack.add(evaluate(token, value1, value2));
		}
		return valueStack.peek();
	}

	@Override
	protected void done() {
		try {
			textField.setText(get().toString());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private void addTokenToStack(Token token) {
		while (!tokenStack.isEmpty()
				&& token.getTokenType().getPriority() < tokenStack.peek()
						.getTokenType().getPriority()) {
			if (tokenStack.peek().getTokenType() == TokenType.OPAREN
					&& token.getTokenType() == TokenType.CPAREN) {
				tokenStack.pop();
				return;
			} else if (tokenStack.peek().getTokenType() == TokenType.OPAREN
					&& !(token.getTokenType() == TokenType.CPAREN)) {
				break;
			}
			valueStack.add(evaluate(tokenStack.pop(), valueStack.pop(),
					valueStack.pop()));
		}
		tokenStack.add(token);
	}

	private Double evaluate(Token token, Double value1, Double value2) {
		if (token.getTokenType() == TokenType.PLUS) {
			return value1.doubleValue() + value2.doubleValue();
		}
		if (token.getTokenType() == TokenType.MINUS) {
			return value2.doubleValue() - value1.doubleValue();
		}
		if (token.getTokenType() == TokenType.DIV) {
			return value2.doubleValue() / value1.doubleValue();
		}
		if (token.getTokenType() == TokenType.MULT) {
			return value1.doubleValue() * value2.doubleValue();
		}
		if (token.getTokenType() == TokenType.EXP) {
			return Math.pow(value2.doubleValue(), value1.doubleValue());
		}
		return null;
	}

}
