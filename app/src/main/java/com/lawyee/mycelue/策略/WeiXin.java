package com.lawyee.mycelue.策略;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.策略
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/13 14:15
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class WeiXin implements Pay {
    Player player;

    public WeiXin(Player player) {
        this.player = player;
    }

    @Override
    public void pay(String name) {
       player.play(name);
    }

}
