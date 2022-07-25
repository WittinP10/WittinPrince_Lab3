package com.greatlearning.main;

import java.util.Stack;

public class BalancingBracket {

	public static boolean balanceBrackets(String expression) {

		Stack<Character> bracket = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {

			char character = expression.charAt(i);

			if (character == '{' || character == '[' || character == '(') {

				bracket.push(character);
				continue;
			}

			char c;

			if (bracket.isEmpty()) {
				return false;
			}

			switch (character) {

			case '}':
				c = bracket.pop();
				if (c == '(' || c == '[')
					return false;
				break;

			case ']':
				c = bracket.pop();
				if (c == '(' || c == '{')
					return false;
				break;

			case ')':
				c = bracket.pop();
				if (c == '[' || c == '{')
					return false;
				break;

			}

		}

		return (bracket.isEmpty());

	}

	public static void main(String[] args) {
		boolean value = balanceBrackets("{()}");

		if (value) {

			System.out.println("Brackets are balanced");
		} else {

			System.out.println("Brackets are not balanced");
		}

	}

}
