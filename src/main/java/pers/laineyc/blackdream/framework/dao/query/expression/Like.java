package pers.laineyc.blackdream.framework.dao.query.expression;

import pers.laineyc.blackdream.framework.util.RegexUtil;

/**
 * Bt
 *
 * @author LaineyC
 */
public class Like extends Expression<String> {

    public Like(String property, String value){
        super(property, RegexUtil.escapeRegexWildcard(value));
    }

}