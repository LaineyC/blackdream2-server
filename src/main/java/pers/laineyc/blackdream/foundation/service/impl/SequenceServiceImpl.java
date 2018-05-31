package pers.laineyc.blackdream.foundation.service.impl;

import org.springframework.stereotype.Service;
import pers.laineyc.blackdream.foundation.service.SequenceService;
import pers.laineyc.blackdream.foundation.util.SnowflakeIdWorker;
import pers.laineyc.blackdream.framework.service.BaseService;

/**
 * SequenceServiceImpl
 *
 * @author LaineyC
 */
@Service
public class SequenceServiceImpl extends BaseService implements SequenceService {

    private SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1L, 1L);

    public String nextId() {
        return Long.valueOf(snowflakeIdWorker.nextId()).toString();
    }

}