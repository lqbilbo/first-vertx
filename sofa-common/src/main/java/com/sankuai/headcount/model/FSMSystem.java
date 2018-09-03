package com.sankuai.headcount.model;

import com.sankuai.headcount.model.valObj.SystemId;

/**
 * FSM管理器
 * @author luoqi04
 */
public abstract class FSMSystem {

    /**
     * 转移
     */
    protected void transmit() {

    }

    /**
     * 更新信息（不导致状态变更）
     */
    protected void update() {

    }

    /**
     * 移除占用人
     * @param employee
     */
    protected void removeEmployee(Employee employee) {

    }

    /**
     * 增加占用人
     * @param employee
     */
    protected void addEmployee(Employee employee) {

    }

    /**
     * 审核
     */
    protected void doCheck() {

    }

    /**
     * 初始化FSM
     */
    protected abstract void FSMInit();

    /**
     * 外部系统导致的变更（占用中，释放中）
     */
    protected FSMState.Phase outerEvent(SystemId systemId) {

        FSMState.Phase phase;
        if (systemId != null) {
            switch (systemId.getId()) {
                case 1:
                  phase = FSMState.Phase.OCCUPIED;
                  return phase;
                case 2:
                  phase = FSMState.Phase.RELEASED;
                  return phase;
                default:
                  phase = FSMState.Phase.LEISURE;
                  return phase;
            }
        }
        return FSMState.Phase.LEISURE;
    }

}
