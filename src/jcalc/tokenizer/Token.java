package jcalc.tokenizer;

public class Token {

	private TokenType tokenType;
	private Double value;

	public Token(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public Token(TokenType tokenType, Double value) {
		this.tokenType = tokenType;
		this.value = value;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public Double getValue() {
		return value;
	}

}
