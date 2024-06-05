package org.zcyj.responsechoice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ResponseMapper {
    int getActiveId(Map<String, Integer> params);

    int getPassiveId(Map<String, Integer> params);

    String getResponseChoice(Map<String, Integer> params);

    String getInvitationChoice(Map<String, Integer> params);
}
