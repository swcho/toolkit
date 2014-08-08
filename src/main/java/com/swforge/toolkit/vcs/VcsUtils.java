package com.swforge.toolkit.vcs;

import static com.swforge.toolkit.vcs.IVcs.TType.ESvn;

/**
 * Created by sungwoo on 14. 8. 8.
 */
public class VcsUtils {
    public static IVcs getVcs(IVcs.TType type) {
        switch (type) {
            case ESvn:
                return new VcsSvn();
            default:
                break;
        }
        return null;
    }
}
