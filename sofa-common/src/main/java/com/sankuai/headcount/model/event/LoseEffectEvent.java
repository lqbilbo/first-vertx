package com.sankuai.headcount.model.event;

import com.sankuai.headcount.model.FSMController;
import com.sankuai.headcount.model.FSMState;
import com.sankuai.headcount.model.entity.HCEntity;
import com.sankuai.headcount.service.ValidateService;

import javax.annotation.Resource;

/**
 * @author luoqi04
 */
public class LoseEffectEvent implements FSMState {

    @Resource
    private FSMController controller;

    @Resource
    private ValidateService validateService;

    @Resource
    private Phase phase;

    @Override
    public boolean enterCond() {
        HCEntity hcEntity = controller.getCurrentHc();
        if (this.phase != Phase.LOSE_EFFECT &&
                validateService.ifEffTimeEarlyThanOrNow(hcEntity.getEffTime())) {
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
