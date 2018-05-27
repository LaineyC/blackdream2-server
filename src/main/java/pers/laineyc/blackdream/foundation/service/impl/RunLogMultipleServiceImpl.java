package pers.laineyc.blackdream.foundation.service.impl;

import pers.laineyc.blackdream.foundation.service.RunLogService;
import pers.laineyc.blackdream.foundation.service.parameter.RunLogSendParameter;
import pers.laineyc.blackdream.framework.service.BaseService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * SequenceServiceImpl
 *
 * @author LaineyC
 */
public class RunLogMultipleServiceImpl extends BaseService implements RunLogService {

    private List<RunLogService> runLogServiceList = new ArrayList<>();

    public RunLogMultipleServiceImpl(List<RunLogService> runLogServiceList) {
        this.runLogServiceList = runLogServiceList;
    }

    public RunLogMultipleServiceImpl(RunLogService... runLogServiceList) {
        this(Arrays.asList(runLogServiceList));
    }

    public void send(RunLogSendParameter parameter) {
        runLogServiceList.forEach(runLogService -> {
            runLogService.send(parameter);
        });
    }

}
