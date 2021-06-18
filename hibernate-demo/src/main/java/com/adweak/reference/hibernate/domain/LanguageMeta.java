package com.adweak.reference.hibernate.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.*;

@Entity
@Table(name = "language_meta", schema = "", catalog = "demo")
public class LanguageMeta {
	private int languageMetaId;
	private int languageId;
	private String languageName;
	private int languageId2;
    private int languageSeq;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	public int getLanguageMetaId() {
		return languageMetaId;
	}
	public void setLanguageMetaId(int languageMetaId) {
		this.languageMetaId = languageMetaId;
	}
	
    @Basic
    @Column(name = "language_id", nullable = false, insertable = false, updatable = false, length = 10)
    public int getLanguageId() {
        return languageId;
    }
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
    
    @Basic
    @Column(name = "language_name", nullable = false, insertable = true, updatable = true, length = 32)
    public String getLanguageName() {
        return languageName;
    }
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
    
    @Basic
    @Column(name = "language_id2", nullable = false, insertable = true, updatable = true, length = 10)
    public int getLanguageId2() {
        return languageId2;
    }
    public void setLanguageId2(int languageId2) {
        this.languageId2 = languageId2;
    }

    @Basic
    @Column(name = "language_seq", nullable = false, insertable = true, updatable = true)
    public int getLanguageSeq() {
        return languageSeq;
    }
    public void setLanguageSeq(int languageSeq) {
        this.languageSeq = languageSeq;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
