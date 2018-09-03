package com.sankuai.headcount.model.event;

import com.sankuai.headcount.model.FSMController;
import com.sankuai.headcount.model.FSMState;

import javax.annotation.Resource;

/**
 * @author luoqi04
 * @version $Id: TransmitEvent.java, v 0.1 2018/9/3 下午9:35 luoqi Exp $
 */
public class TransmitEvent implements FSMState {

    @Resource
    private FSMController controller;

    @Resource
    private Phase phase;

    @Override
    public boolean enterCond() {
        controller.transmit();
        return true;
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
