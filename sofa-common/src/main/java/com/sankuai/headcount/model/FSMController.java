package com.sankuai.headcount.model;

import com.sankuai.headcount.model.entity.HCEntity;
import org.springframework.stereotype.Component;

/**
 * FSM控制器，进行状态的添加
 * @author luoqi04
 */
@Component
public class FSMController extends FSMSystem {
    FSMController(HCEntity hcEntity) {
        super(hcEntity);
    }

    @Override
    protected void FSMInit() {

    }
}
