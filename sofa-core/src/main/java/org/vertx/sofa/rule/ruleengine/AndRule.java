package org.vertx.sofa.rule.ruleengine;

import org.vertx.sofa.rule.RuleI;

/**
 * 组合And的业务规则
 * @author xueliang.sxl
 *
 */
public class AndRule extends AbstractRule {
	RuleI one;
	RuleI other;

	public AndRule(RuleI x, RuleI y){
		one = x;
		other = y;
	}

	@Override
	public boolean check(Object candidate) {
		return one.check(candidate) && other.check(candidate);
	}

}
