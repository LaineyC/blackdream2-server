package pers.laineyc.blackdream.foundation.service;

import pers.laineyc.blackdream.foundation.service.parameter.RunLogSendParameter;

/**
 * SequenceService
 *
 * @author LaineyC
 */
public interface RunLogService {

    void send(RunLogSendParameter parameter);

}
