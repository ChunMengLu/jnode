package com.lcm.jnode.model;

import com.jfinal.plugin.activerecord.Model;

public class MailVerify extends Model<Blog> {
    
    private static final long serialVersionUID = -2208881735662609833L;
    
    public static final MailVerify dao = new MailVerify();
}
