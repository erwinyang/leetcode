
package com.leetcode;

import java.util.*;
import java.lang.*;

public class ValidNumber {

	public static void main(String[] args) {
		// \s(+|-)?*[0-9]+(\.[0-9+])?(e(+|-)?[0-9]+)?\s*
		System.out.println(new ValidNumber().isNumber("46.e3"));
	}

	enum State {
		START,
		SIGN,
		NUMBER,
		POINT,
		ZEROP,
		FRAC,
		E,
		ESIGN,
		ENUMBER,
		END,
		UNKNOWN;
	}

	public boolean isNumber(String s) {
		State state = State.START;
		for (int i = 0; i < s.length(); i++) {
			state = nextState(state, s.charAt(i));
		}
		return state == State.END || state == State.NUMBER || state == State.FRAC
				|| state == State.ENUMBER || state == State.POINT;
	}

	public State nextState(State state, char c) {
		if (state == State.START) {
			if (c == ' ') {
				return State.START;
			} else if (isDigit(c)) {
				return State.NUMBER;
			} else if (c == '.') {
				return State.ZEROP;
			} else if (c == '-' || c == '+') {
				return State.SIGN;
			}
		} else if (state == State.SIGN) {
			if (isDigit(c)) {
				return State.NUMBER;
			} else if (c == '.') {
				return State.ZEROP;
			}
		} else if (state == State.NUMBER) {
			if (c == '.') {
				return State.POINT;
			} else if (c == 'e' || c == 'E') {
				return State.E;
			} else if (isDigit(c)) {
				return State.NUMBER;
			} else if (c == ' ') {
				return State.END;
			}
		} else if (state == State.POINT) {
			if (isDigit(c)) {
				return State.FRAC;
			} else if (c == ' ') {
				return State.END;
			} else if (c == 'e' || c == 'E') {
				return State.E;
			}
		} else if (state == State.ZEROP) {
			if (isDigit(c)) {
				return State.FRAC;
			}
		} else if (state == State.FRAC) {
			if (isDigit(c)) {
				return State.FRAC;
			} else if (c == 'e' || c == 'E') {
				return State.E;
			} else if (c == ' ') {
				return State.END;
			}
		} else if (state == State.E) {
			if (isDigit(c)) {
				return State.ENUMBER;
			} else if (c == '-' || c == '+') {
				return State.ESIGN;
			}
		} else if (state == State.ESIGN) {
			if (isDigit(c)) {
				return State.ENUMBER;
			}
		} else if (state == State.ENUMBER) {
			if (isDigit(c)) {
				return State.ENUMBER;
			} else if (c == ' ') {
				return State.END;
			}
		} else if (state == State.END) {
			if (c == ' ') return State.END;
		}
		return State.UNKNOWN;
	}

	public boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
}
