package com.sankuai.headcount.model.event;

import com.sankuai.headcount.model.FSMController;
import com.sankuai.headcount.model.FSMState;

import javax.annotation.Resource;

/**
 * @author luoqi04
 */
public class UpdateEvent implements FSMState {

    @Resource
    private FSMController controller;

    @Resource
    private ValidateService validateService;

    @Resource
    private Phase phase;

    @Override
    public boolean enterCond() {
        HCEntity hcEntity = controller.getCurrentHc();
        if(validateService.ifKeyFieldsChanged(hcEntity)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean exitCond() {
        if (phase.isChanged(this)) {
            return true;
        }
        return false;
    }

    @Override
    public void onStay() {
        //some CRUDs.
        //state changed & write log
    }

}