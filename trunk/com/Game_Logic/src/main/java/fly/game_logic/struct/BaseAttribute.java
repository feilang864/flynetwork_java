package fly.game_logic.struct;

import java.io.Serializable;

/**
 * 基础属性结果
 *
 * @author Vicky
 * @mail eclipser@163.com
 * @phone 13618074943
 */
public class BaseAttribute implements Serializable {

    private static final long serialVersionUID = 7331996190994084714L;
    private static final int MAX_PROBABILITY = 10000;

    //物理攻击下限
    private int dcmin;
    //物理攻击上限
    private int dcmax;
    //魔法攻击下限
    private int mcmin;
    //魔法攻击上限
    private int mcmax;
    //物理防御下限
    private int acmin;
    //物理防御上限
    private int acmax;
    //魔法防御下限
    private int macmin;
    //魔法防御上限
    private int macmax;
    //闪避
    private int juckmin;
    //闪避
    private int juckmax;
    //命中率
    private int hitmin;
    //命中率
    private int hitmax;
    //韧性
    private int toughnessmin;
    //韧性
    private int toughnessmax;
    //暴击几率
    private int critmin;
    //暴击几率
    private int critmax;
    //暴击值
    private int critvaluemin;
    //暴击值
    private int critvaluemax;
    //格挡下限
    private int gedangmin;
    //格挡上限
    private int gedangmax;
    //自动回血
    private int autohp;
    //自动回魔法值
    private int automp;
    //最大血量
    private int hpmax;
    //最大魔法
    private int mpmax;
    //升级的最大经验值
    private long expmax;
    //速度
    private int speed;

    //穿透
    private int damagemin;
    //穿透
    private int damagemax;

    //物理减伤
    private int dcharmdelmin;
    //物理减伤
    private int dcharmdelmax;
    //魔法减伤
    private int mcharmdelmin;
    //魔法减伤
    private int mcharmdelmax;

    //物理反伤
    private int undcharmdelmin;
    //物理反伤
    private int undcharmdelmax;
    //魔法反伤
    private int unmcharmdelmin;
    //魔法反伤
    private int unmcharmdelmax;

    //吸血属性
    private int drains;

    //--------------上面需要传到前端，下面不需要----------------//
    //经验加成
    private int expmultiple;
//    //技能等级加成
//    private HashMap<Integer, Integer> skillLevelUp = new HashMap<>();

    public int getDcmin() {
        return dcmin;
    }

    public void setDcmin(int dcmin) {
        this.dcmin = dcmin;
    }

    public int getDcmax() {
        return dcmax;
    }

    public void setDcmax(int dcmax) {
        this.dcmax = dcmax;
    }

    public int getMcmin() {
        return mcmin;
    }

    public void setMcmin(int mcmin) {
        this.mcmin = mcmin;
    }

    public int getMcmax() {
        return mcmax;
    }

    public void setMcmax(int mcmax) {
        this.mcmax = mcmax;
    }

    public int getAcmin() {
        return acmin;
    }

    public void setAcmin(int acmin) {
        this.acmin = acmin;
    }

    public int getAcmax() {
        return acmax;
    }

    public void setAcmax(int acmax) {
        this.acmax = acmax;
    }

    public int getMacmin() {
        return macmin;
    }

    public void setMacmin(int macmin) {
        this.macmin = macmin;
    }

    public int getMacmax() {
        return macmax;
    }

    public void setMacmax(int macmax) {
        this.macmax = macmax;
    }

    public int getJuckmin() {
        return juckmin;
    }

    public void setJuckmin(int juckmin) {
        this.juckmin = juckmin;
    }

    public int getJuckmax() {
        return juckmax;
    }

    public void setJuckmax(int juckmax) {
        this.juckmax = juckmax;
    }

    public int getHitmin() {
        return hitmin;
    }

    public void setHitmin(int hitmin) {
        this.hitmin = hitmin;
    }

    public int getHitmax() {
        return hitmax;
    }

    public void setHitmax(int hitmax) {
        this.hitmax = hitmax;
    }

    public int getToughnessmin() {
        return toughnessmin;
    }

    public void setToughnessmin(int toughnessmin) {
        this.toughnessmin = toughnessmin;
    }

    public int getToughnessmax() {
        return toughnessmax;
    }

    public void setToughnessmax(int toughnessmax) {
        this.toughnessmax = toughnessmax;
    }

    public int getCritmin() {
        return critmin;
    }

    public void setCritmin(int critmin) {
        this.critmin = critmin;
    }

    public int getCritmax() {
        return critmax;
    }

    public void setCritmax(int critmax) {
        this.critmax = critmax;
    }

    public int getCritvaluemin() {
        return critvaluemin;
    }

    public void setCritvaluemin(int critvaluemin) {
        this.critvaluemin = critvaluemin;
    }

    public int getCritvaluemax() {
        return critvaluemax;
    }

    public void setCritvaluemax(int critvaluemax) {
        this.critvaluemax = critvaluemax;
    }

    public int getGedangmin() {
        return gedangmin;
    }

    public void setGedangmin(int gedangmin) {
        this.gedangmin = gedangmin;
    }

    public int getGedangmax() {
        return gedangmax;
    }

    public void setGedangmax(int gedangmax) {
        this.gedangmax = gedangmax;
    }

    public int getAutohp() {
        return autohp;
    }

    public void setAutohp(int autohp) {
        this.autohp = autohp;
    }

    public int getAutomp() {
        return automp;
    }

    public void setAutomp(int automp) {
        this.automp = automp;
    }

    public int getHpmax() {
        return hpmax;
    }

    public void setHpmax(int hpmax) {
        this.hpmax = hpmax;
    }

    public int getMpmax() {
        return mpmax;
    }

    public void setMpmax(int mpmax) {
        this.mpmax = mpmax;
    }

    public long getExpmax() {
        return expmax;
    }

    public void setExpmax(long expmax) {
        this.expmax = expmax;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDcharmdelmin() {
        return dcharmdelmin;
    }

    public void setDcharmdelmin(int dcharmdelmin) {
        this.dcharmdelmin = dcharmdelmin;
    }

    public int getDcharmdelmax() {
        return dcharmdelmax;
    }

    public void setDcharmdelmax(int dcharmdelmax) {
        this.dcharmdelmax = dcharmdelmax;
    }

    public int getUndcharmdelmin() {
        return undcharmdelmin;
    }

    public void setUndcharmdelmin(int undcharmdelmin) {
        this.undcharmdelmin = undcharmdelmin;
    }

    public int getUndcharmdelmax() {
        return undcharmdelmax;
    }

    public void setUndcharmdelmax(int undcharmdelmax) {
        this.undcharmdelmax = undcharmdelmax;
    }

    public int getDamagemin() {
        return damagemin;
    }

    public void setDamagemin(int damagemin) {
        this.damagemin = damagemin;
    }

    public int getDamagemax() {
        return damagemax;
    }

    public void setDamagemax(int damagemax) {
        this.damagemax = damagemax;
    }

    public int getMcharmdelmin() {
        return mcharmdelmin;
    }

    public void setMcharmdelmin(int mcharmdelmin) {
        this.mcharmdelmin = mcharmdelmin;
    }

    public int getMcharmdelmax() {
        return mcharmdelmax;
    }

    public void setMcharmdelmax(int mcharmdelmax) {
        this.mcharmdelmax = mcharmdelmax;
    }

    public int getUnmcharmdelmin() {
        return unmcharmdelmin;
    }

    public void setUnmcharmdelmin(int unmcharmdelmin) {
        this.unmcharmdelmin = unmcharmdelmin;
    }

    public int getUnmcharmdelmax() {
        return unmcharmdelmax;
    }

    public void setUnmcharmdelmax(int unmcharmdelmax) {
        this.unmcharmdelmax = unmcharmdelmax;
    }

    public int getExpmultiple() {
        return expmultiple;
    }

    public void setExpmultiple(int expmultiple) {
        this.expmultiple = expmultiple;
    }

    public int getDrains() {
        return drains;
    }

    public void setDrains(int drains) {
        this.drains = drains;
    }

//    public HashMap<Integer, Integer> getSkillLevelUp() {
//        if (skillLevelUp == null) {
//            skillLevelUp = new HashMap<>();
//        }
//        return skillLevelUp;
//    }
//
//    public void setSkillLevelUp(HashMap<Integer, Integer> skillLevelUp) {
//        this.skillLevelUp = skillLevelUp;
//    }
    /**
     * 属性减
     *
     * @param tmpAbility
     */
    public void subtract(BaseAttribute tmpAbility) {
        if (tmpAbility == null) {
            return;
        }
        this.dcmin -= tmpAbility.dcmin;
        this.dcmax -= tmpAbility.dcmax;
        this.mcmin -= tmpAbility.mcmin;
        this.mcmax -= tmpAbility.mcmax;
        this.acmin -= tmpAbility.acmin;
        this.acmax -= tmpAbility.acmax;
        this.macmin -= tmpAbility.macmin;
        this.macmax -= tmpAbility.macmax;
        this.gedangmax -= tmpAbility.gedangmax;
        this.gedangmin -= tmpAbility.gedangmin;
        this.juckmin -= tmpAbility.juckmin;
        this.juckmax -= tmpAbility.juckmax;
        this.hitmin -= tmpAbility.hitmin;
        this.hitmax -= tmpAbility.hitmax;
        this.toughnessmin -= tmpAbility.toughnessmin;
        this.toughnessmax -= tmpAbility.toughnessmax;
        this.critmin -= tmpAbility.critmin;
        this.critmax -= tmpAbility.critmax;
        this.critvaluemin -= tmpAbility.critvaluemin;
        this.critvaluemax -= tmpAbility.critvaluemax;
        this.autohp -= tmpAbility.autohp;
        this.automp -= tmpAbility.automp;
        this.hpmax -= tmpAbility.hpmax;
        this.mpmax -= tmpAbility.mpmax;
        this.expmax -= tmpAbility.expmax;
        this.speed -= tmpAbility.speed;
        this.dcharmdelmin -= tmpAbility.dcharmdelmin;
        this.dcharmdelmax -= tmpAbility.dcharmdelmax;
        this.undcharmdelmin -= tmpAbility.undcharmdelmin;
        this.undcharmdelmax -= tmpAbility.undcharmdelmax;
        this.damagemin -= tmpAbility.damagemin;
        this.damagemax -= tmpAbility.damagemax;
        this.mcharmdelmin -= tmpAbility.mcharmdelmin;
        this.mcharmdelmax -= tmpAbility.mcharmdelmax;
        this.unmcharmdelmin -= tmpAbility.unmcharmdelmin;
        this.unmcharmdelmax -= tmpAbility.unmcharmdelmax;
        this.expmultiple -= tmpAbility.expmultiple;
        this.drains -= tmpAbility.drains;
//        if (tmpAbility.skillLevelUp != null) {
//            for (HashMap.Entry<Integer, Integer> entry : tmpAbility.getSkillLevelUp().entrySet()) {
//                if (getSkillLevelUp().containsKey(entry.getKey())) {
//                    skillLevelUp.put(entry.getKey(), 0);
//                }
//                skillLevelUp.put(entry.getKey(), getSkillLevelUp().get(entry.getKey()) - entry.getValue());
//                if (getSkillLevelUp().get(entry.getKey()) < 0) {
//                    skillLevelUp.put(entry.getKey(), 0);
//                }
//            }
//        }
    }

    /**
     * 属性叠加
     *
     * @param tmpAbility
     */
    public void add(BaseAttribute tmpAbility) {
        if (tmpAbility == null) {
            return;
        }
        this.dcmin += tmpAbility.dcmin;
        this.dcmax += tmpAbility.dcmax;
        this.mcmin += tmpAbility.mcmin;
        this.mcmax += tmpAbility.mcmax;

        this.acmin += tmpAbility.acmin;
        this.acmax += tmpAbility.acmax;
        this.macmin += tmpAbility.macmin;
        this.macmax += tmpAbility.macmax;

        this.gedangmax += tmpAbility.gedangmax;
        this.gedangmin += tmpAbility.gedangmin;

        this.juckmin += tmpAbility.juckmin;
        this.juckmax += tmpAbility.juckmax;
        this.hitmin += tmpAbility.hitmin;
        this.hitmax += tmpAbility.hitmax;
        this.toughnessmin += tmpAbility.toughnessmin;
        this.toughnessmax += tmpAbility.toughnessmax;
        this.critmin += tmpAbility.critmin;
        this.critmax += tmpAbility.critmax;
        this.critvaluemin += tmpAbility.critvaluemin;
        this.critvaluemax += tmpAbility.critvaluemax;
        this.autohp += tmpAbility.autohp;
        this.automp += tmpAbility.automp;
        this.hpmax += tmpAbility.hpmax;
        this.mpmax += tmpAbility.mpmax;
        this.expmax += tmpAbility.expmax;
        this.speed += tmpAbility.speed;
        this.dcharmdelmin += tmpAbility.dcharmdelmin;
        this.dcharmdelmax += tmpAbility.dcharmdelmax;
        this.undcharmdelmin += tmpAbility.undcharmdelmin;
        this.undcharmdelmax += tmpAbility.undcharmdelmax;
        this.mcharmdelmin += tmpAbility.mcharmdelmin;
        this.mcharmdelmax += tmpAbility.mcharmdelmax;
        this.unmcharmdelmin += tmpAbility.unmcharmdelmin;
        this.unmcharmdelmax += tmpAbility.unmcharmdelmax;
        this.damagemin += tmpAbility.damagemin;
        this.damagemax += tmpAbility.damagemax;
        this.expmultiple += tmpAbility.expmultiple;
        this.drains += tmpAbility.drains;
//        if (tmpAbility.skillLevelUp != null) {
//            for (HashMap.Entry<Integer, Integer> entry : tmpAbility.getSkillLevelUp().entrySet()) {
//                if (getSkillLevelUp().containsKey(entry.getKey())) {
//                    skillLevelUp.put(entry.getKey(), 0);
//                }
//                skillLevelUp.put(entry.getKey(), getSkillLevelUp().get(entry.getKey()) + entry.getValue());
//            }
//        }
    }

    /**
     * 属性加成(百分比)
     *
     * @param abilityPercent
     * @return
     */
    public BaseAttribute addAbilityPercent(BaseAttribute abilityPercent) {
        if (abilityPercent == null) {
            return this;
        }
        this.setDcmin((int) Math.ceil(this.getDcmin() * (1 + (double) abilityPercent.getDcmin() / MAX_PROBABILITY)));
        this.setDcmax((int) Math.ceil(this.getDcmax() * (1 + (double) abilityPercent.getDcmax() / MAX_PROBABILITY)));
        this.setMcmin((int) Math.ceil(this.getMcmin() * (1 + (double) abilityPercent.getMcmin() / MAX_PROBABILITY)));
        this.setMcmax((int) Math.ceil(this.getMcmax() * (1 + (double) abilityPercent.getMcmax() / MAX_PROBABILITY)));

        this.setAcmin((int) Math.ceil(this.getAcmin() * (1 + (double) abilityPercent.getAcmin() / MAX_PROBABILITY)));
        this.setAcmax((int) Math.ceil(this.getAcmax() * (1 + (double) abilityPercent.getAcmax() / MAX_PROBABILITY)));
        this.setMacmin((int) Math.ceil(this.getMacmin() * (1 + (double) abilityPercent.getMacmin() / MAX_PROBABILITY)));
        this.setMacmax((int) Math.ceil(this.getMacmax() * (1 + (double) abilityPercent.getMacmax() / MAX_PROBABILITY)));

        this.setJuckmin((int) Math.ceil(this.getJuckmin() * (1 + (double) abilityPercent.getJuckmin() / MAX_PROBABILITY)));
        this.setJuckmax((int) Math.ceil(this.getJuckmax() * (1 + (double) abilityPercent.getJuckmax() / MAX_PROBABILITY)));

        this.setHitmin((int) Math.ceil(this.getHitmin() * (1 + (double) abilityPercent.getHitmin() / MAX_PROBABILITY)));
        this.setHitmax((int) Math.ceil(this.getHitmax() * (1 + (double) abilityPercent.getHitmax() / MAX_PROBABILITY)));

        this.setToughnessmin((int) Math.ceil(this.getToughnessmin() * (1 + (double) abilityPercent.getToughnessmin() / MAX_PROBABILITY)));
        this.setToughnessmax((int) Math.ceil(this.getToughnessmax() * (1 + (double) abilityPercent.getToughnessmax() / MAX_PROBABILITY)));

        this.setCritmax((int) Math.ceil(this.getCritmax() * (1 + (double) abilityPercent.getCritmax() / MAX_PROBABILITY)));
        this.setCritmin((int) Math.ceil(this.getCritmin() * (1 + (double) abilityPercent.getCritmin() / MAX_PROBABILITY)));

        this.setCritvaluemin((int) Math.ceil(this.getCritvaluemin() * (1 + (double) abilityPercent.getCritvaluemin() / MAX_PROBABILITY)));
        this.setCritvaluemax((int) Math.ceil(this.getCritvaluemax() * (1 + (double) abilityPercent.getCritvaluemax() / MAX_PROBABILITY)));

        this.setGedangmin((int) Math.ceil(this.getGedangmin() * (1 + (double) abilityPercent.getGedangmin() / MAX_PROBABILITY)));
        this.setGedangmax((int) Math.ceil(this.getGedangmax() * (1 + (double) abilityPercent.getGedangmax() / MAX_PROBABILITY)));

        this.setHpmax((int) Math.ceil(this.getHpmax() * (1 + (double) abilityPercent.getHpmax() / MAX_PROBABILITY)));
        this.setMpmax((int) Math.ceil(this.getMpmax() * (1 + (double) abilityPercent.getMpmax() / MAX_PROBABILITY)));

        this.setDcharmdelmin((int) Math.ceil(this.getDcharmdelmin() * (1 + (double) abilityPercent.getDcharmdelmin() / MAX_PROBABILITY)));
        this.setDcharmdelmax((int) Math.ceil(this.getDcharmdelmax() * (1 + (double) abilityPercent.getDcharmdelmax() / MAX_PROBABILITY)));

        this.setUndcharmdelmin((int) Math.ceil(this.getUndcharmdelmin() * (1 + (double) abilityPercent.getUndcharmdelmin() / MAX_PROBABILITY)));
        this.setUndcharmdelmax((int) Math.ceil(this.getUndcharmdelmax() * (1 + (double) abilityPercent.getUndcharmdelmax() / MAX_PROBABILITY)));

        this.setDamagemin((int) Math.ceil(this.getDamagemin() * (1 + (double) abilityPercent.getDamagemin() / MAX_PROBABILITY)));
        this.setDamagemax((int) Math.ceil(this.getDamagemax() * (1 + (double) abilityPercent.getDamagemax() / MAX_PROBABILITY)));

        this.setMcharmdelmin((int) Math.ceil(this.getMcharmdelmin() * (1 + (double) abilityPercent.getMcharmdelmin() / MAX_PROBABILITY)));
        this.setMcharmdelmax((int) Math.ceil(this.getMcharmdelmax() * (1 + (double) abilityPercent.getMcharmdelmax() / MAX_PROBABILITY)));

        this.setUnmcharmdelmin((int) Math.ceil(this.getUnmcharmdelmin() * (1 + (double) abilityPercent.getUnmcharmdelmin() / MAX_PROBABILITY)));
        this.setUnmcharmdelmax((int) Math.ceil(this.getUnmcharmdelmax() * (1 + (double) abilityPercent.getUnmcharmdelmax() / MAX_PROBABILITY)));

        this.setSpeed((int) Math.ceil(this.getSpeed() * (1 + (double) abilityPercent.getSpeed() / MAX_PROBABILITY)));

        return this;
    }

    /**
     * 属性清零
     *
     */
    public void clearZero() {
        this.dcmin = 0;
        this.dcmax = 0;
        this.mcmin = 0;
        this.mcmax = 0;
        this.acmin = 0;
        this.acmax = 0;
        this.macmin = 0;
        this.macmax = 0;
        this.gedangmax = 0;
        this.gedangmin = 0;
        this.juckmin = 0;
        this.juckmax = 0;
        this.hitmin = 0;
        this.hitmax = 0;
        this.toughnessmin = 0;
        this.toughnessmax = 0;
        this.critmin = 0;
        this.critmax = 0;
        this.critvaluemin = 0;
        this.critvaluemax = 0;
        this.autohp = 0;
        this.automp = 0;
        this.hpmax = 0;
        this.mpmax = 0;
        this.expmax = 0;
        this.speed = 0;
        this.dcharmdelmin = 0;
        this.dcharmdelmax = 0;
        this.undcharmdelmin = 0;
        this.undcharmdelmax = 0;
        this.damagemin = 0;
        this.damagemax = 0;
        this.mcharmdelmin = 0;
        this.mcharmdelmax = 0;
        this.unmcharmdelmin = 0;
        this.unmcharmdelmax = 0;
        this.expmultiple = 0;
        this.drains = 0;
//        this.skillLevelUp = new HashMap<>();
    }

    /**
     * 属性小于0的处理
     */
    public void zeroAbility() {
        this.dcmin = this.dcmin > 0 ? this.dcmin : 0;
        this.dcmax = this.dcmax > 0 ? this.dcmax : 0;
        this.mcmin = this.mcmin > 0 ? this.mcmin : 0;
        this.mcmax = this.mcmax > 0 ? this.mcmax : 0;
        this.acmin = this.acmin > 0 ? this.acmin : 0;
        this.acmax = this.acmax > 0 ? this.acmax : 0;
        this.macmin = this.macmin > 0 ? this.macmin : 0;
        this.macmax = this.macmax > 0 ? this.macmax : 0;
        this.gedangmax = this.gedangmax > 0 ? this.gedangmax : 0;
        this.gedangmin = this.gedangmin > 0 ? this.gedangmin : 0;
        this.juckmin = this.juckmin > 0 ? this.juckmin : 0;
        this.juckmax = this.juckmax > 0 ? this.juckmax : 0;
        this.hitmin = this.hitmin > 0 ? this.hitmin : 0;
        this.hitmax = this.hitmax > 0 ? this.hitmax : 0;
        this.toughnessmin = this.toughnessmin > 0 ? this.toughnessmin : 0;
        this.toughnessmax = this.toughnessmax > 0 ? this.toughnessmax : 0;
        this.critmin = this.critmin > 0 ? this.critmin : 0;
        this.critmax = this.critmax > 0 ? this.critmax : 0;
        this.critvaluemin = this.critvaluemin > 0 ? this.critvaluemin : 0;
        this.critvaluemax = this.critvaluemax > 0 ? this.critvaluemax : 0;
        this.autohp = this.autohp > 0 ? this.autohp : 0;
        this.automp = this.automp > 0 ? this.automp : 0;
        this.hpmax = this.hpmax > 0 ? this.hpmax : 0;
        this.mpmax = this.mpmax > 0 ? this.mpmax : 0;
        this.expmax = this.expmax > 0 ? this.expmax : 0;
        this.speed = this.speed < 0 ? 0 : (this.speed > 8000 ? 8000 : this.speed); // 移动速度介于 0 -8000
        this.dcharmdelmin = this.dcharmdelmin > 0 ? this.dcharmdelmin : 0;
        this.dcharmdelmax = this.dcharmdelmax > 0 ? this.dcharmdelmax : 0;
        this.undcharmdelmin = this.undcharmdelmin > 0 ? this.undcharmdelmin : 0;
        this.undcharmdelmax = this.undcharmdelmax > 0 ? this.undcharmdelmax : 0;
        this.damagemin = this.damagemin > 0 ? this.damagemin : 0;
        this.damagemax = this.damagemax > 0 ? this.damagemax : 0;
        this.mcharmdelmin = this.mcharmdelmin > 0 ? this.mcharmdelmin : 0;
        this.mcharmdelmax = this.mcharmdelmax > 0 ? this.mcharmdelmax : 0;
        this.unmcharmdelmin = this.unmcharmdelmin > 0 ? this.unmcharmdelmin : 0;
        this.unmcharmdelmax = this.unmcharmdelmax > 0 ? this.unmcharmdelmax : 0;
        this.expmultiple = this.expmultiple > 0 ? this.expmultiple : 0;
        this.drains = this.drains > 0 ? this.drains : 0;
//        this.skillLevelUp = new HashMap<>();
    }

    @Override
    public String toString() {
        return "BaseAbility{" + "dcmin=" + dcmin + ", dcmax=" + dcmax + ", mcmin=" + mcmin + ", mcmax=" + mcmax + ", acmin=" + acmin + ", acmax=" + acmax + ", macmin=" + macmin + ", macmax=" + macmax + ", juckmin=" + juckmin + ", juckmax=" + juckmax + ", hitmin=" + hitmin + ", hitmax=" + hitmax + ", toughnessmin=" + toughnessmin + ", toughnessmax=" + toughnessmax + ", critmin=" + critmin + ", critmax=" + critmax + ", critvaluemin=" + critvaluemin + ", critvaluemax=" + critvaluemax + ", gedangmin=" + gedangmin + ", gedangmax=" + gedangmax + ", autohp=" + autohp + ", automp=" + automp + ", hpmax=" + hpmax + ", mpmax=" + mpmax + ", expmax=" + expmax + ", speed=" + speed + ", damagemin=" + damagemin + ", damagemax=" + damagemax + ", dcharmdelmin=" + dcharmdelmin + ", dcharmdelmax=" + dcharmdelmax + ", mcharmdelmin=" + mcharmdelmin + ", mcharmdelmax=" + mcharmdelmax + ", undcharmdelmin=" + undcharmdelmin + ", undcharmdelmax=" + undcharmdelmax + ", unmcharmdelmin=" + unmcharmdelmin + ", unmcharmdelmax=" + unmcharmdelmax + ", drains=" + drains + ", expmultiple=" + expmultiple + '}';
    }

}
