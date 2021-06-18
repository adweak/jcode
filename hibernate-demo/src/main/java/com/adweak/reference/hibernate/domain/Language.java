package com.adweak.reference.hibernate.domain;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "language", schema = "", catalog = "demo")
public class Language {
    private int languageId;
	@ApiModelProperty(name = "languageDesc", value = "语言描述")
    private String languageDesc;
	@ApiModelProperty(name = "isoCode", value = "ISO编码")
    private String isoCode;
	@ApiModelProperty(name = "nativeName", value = "本语言名称")
    private String nativeName;
	@ApiModelProperty(name = "seqNo", value = "权重，显示顺序")
    private int seqNo;
	@ApiModelProperty(name = "status", value = "状态， 0：禁用， 1：启用")
    private int status;
    private Date createTime;
    private Date updateTime;
	@ApiModelProperty(name = "isDefault", value = "0否1是（是否是预置数据）不需要传")
    private int isDefault;
	private List<LanguageMeta> metaList;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getLanguageId() {
        return languageId;
    }
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
	
	@Basic
	@Column(name = "languagedesc", nullable = false, insertable = true, updatable = true)
	public String getLanguageDesc() {
		return languageDesc;
	}
	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}

	@Basic
	@Column(name = "iso_code", nullable = false, insertable = true, updatable = true)
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	@Basic
	@Column(name = "native_name", nullable = false, insertable = true, updatable = true)
	public String getNativeName() {
		return nativeName;
	}
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	@Basic
	@Column(name = "seq_no", nullable = false, insertable = true, updatable = true)
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	@Basic
	@Column(name = "status", nullable = false, insertable = true, updatable = true)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Basic
	@Column(name = "create_time", nullable = false, insertable = true, updatable = true)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Basic
	@Column(name = "update_time", nullable = false, insertable = true, updatable = true)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Basic
	@Column(name = "isdefault", nullable = false, insertable = true, updatable = false)
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

    @OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    @JoinColumn(name = "language_id")
	public List<LanguageMeta> getMetaList() {
		return metaList;
	}
	public void setMetaList(List<LanguageMeta> metaList) {
		this.metaList = metaList;
	}

	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
