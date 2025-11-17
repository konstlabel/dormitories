package com.konstl.dormitories.security;

import com.konstl.dormitories.security.CurrentUser.UserPrincipal;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class DormitoryPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        return false; // не используется
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        if (!(auth.getPrincipal() instanceof UserPrincipal user)) return false;
        if (!auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_HEADER"))) return true;

        Long dormitoryId = (Long) targetId;
        return user.getDormitoryId() != null && user.getDormitoryId().equals(dormitoryId);
    }
}
