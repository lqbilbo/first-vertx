package com.sankuai.headcount.model;

/**
 * HC状态机（F(S, E) -> (A, S')）
 * @author luoqi04
 */
public interface FSMState {

    /**
     * 进入条件：某事件触发(E)
     * @return
     */
    boolean enterCond();

    /**
     * 退出条件：某事件触发(E)
     * @return
     */
    boolean exitCond();

    /**
     * 进入该状态的逻辑，由子类实现(A)
     */
    void onEnter();

    /**
     * 退出该状态的逻辑，由子类实现(A)
     */
    void onExit();

    enum Phase {

        OVER_STAFF(true),

        LEISURE(false),

        ON_JOB(false),

        UNCHECKED(false),

        LOSE_EFFECT(false),

        OCCUPIED(false),

        RELEASED(false);

        private final boolean current;

        Phase(boolean current) {
            this.current = current;
        }

        public boolean isCurrent() {
          return current;
        }
    }


}
