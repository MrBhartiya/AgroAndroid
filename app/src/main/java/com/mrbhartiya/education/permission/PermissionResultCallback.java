package com.mrbhartiya.education.permission;

import java.util.ArrayList;

/**
 * Created by Radha  on 16/01/19.
 */


public interface PermissionResultCallback
{
    void PermissionGranted(int request_code);

    void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions);

    void PermissionDenied(int request_code);

    void NeverAskAgain(int request_code);
}
