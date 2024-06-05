package org.zcyj.responsechoice.service;

import java.util.List;
import java.util.Map;

public interface ResponseService {
    String getResponseChoice(Map<String, Integer> params);

    String getInvitationChoice(Map<String, Integer> params);
}
