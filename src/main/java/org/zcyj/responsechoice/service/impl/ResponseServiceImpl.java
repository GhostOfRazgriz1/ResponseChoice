package org.zcyj.responsechoice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zcyj.responsechoice.mapper.ResponseMapper;
import org.zcyj.responsechoice.service.ResponseService;

import java.util.HashMap;
import java.util.Map;

@Service("responseService")
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseMapper responseMapper;

    @Override
    public String getResponseChoice(Map<String, Integer> params) {
        return responseMapper.getResponseChoice(getIdPair(params));
    }

    @Override
    public String getInvitationChoice(Map<String, Integer> params) {
        return responseMapper.getInvitationChoice(getIdPair(params));
    }

    private Map<String, Integer> getIdPair(Map<String, Integer> params) {
        Map<String,Integer> activeMap = new HashMap<>();
        activeMap.put("is_active", 1);
        activeMap.put("sample", params.get("active_sample"));
        activeMap.put("requirement", params.get("requirement"));
        activeMap.put("score", params.get("active_score"));
        Map<String, Integer> passiveMap = new HashMap<>();
        passiveMap.put("is_active", 0);
        passiveMap.put("sample", params.get("passive_sample"));
        passiveMap.put("score", params.get("passive_score"));
        int activeId = responseMapper.getActiveId(activeMap);
        int passiveId = responseMapper.getPassiveId(passiveMap);
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("active_id", activeId);
        resultMap.put("passive_id", passiveId);
        return resultMap;
    }
}
