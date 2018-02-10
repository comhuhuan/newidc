package com.act.idc.entity;

import com.act.framework.entity.StandardEntity;
import com.act.mapper.annotation.ColumnTitle;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Table(name = "tab_interface_config")
public class TabInterfaceConfigEntity extends StandardEntity {
    /**
     * 接口系统配置表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interface_id")
    @ColumnTitle("接口系统配置表id")
    private int interfaceId;

    /**
     * 机房编号
     */
    @NotEmpty
    @Length(max=14)
    @Column(name = "service_code")
    @ColumnTitle("机房编号")
    private String serviceCode;

    /**
     * 接口系统类型 1-EU 2-备案系统 3-访问日志留存系统
     */
    @NotEmpty
    @Column(name = "interface_type")
    @ColumnTitle("接口系统类型")
    private Byte interfaceType;

    /**
     * 接口系统名称
     */
    @NotEmpty
    @Length(max=50)
    @Column(name = "interface_name")
    @ColumnTitle("接口系统名称")
    private String interfaceName;

    /**
     * 用户口令设置
     */
    @NotEmpty
    @Length(max=25)
    @Column(name = "interface_user_pass")
    @ColumnTitle("用户口令设置")
    private String interfaceUserPass;

    /**
     * 消息认证密钥
     */
    @NotEmpty
    @Length(max=50)
    @Column(name = "interface_msg_key")
    @ColumnTitle("消息认证密钥")
    private String interfaceMsgKey;

    /**
     * 加密密钥
     */
    @NotEmpty
    @Length(max=50)
    @Column(name = "interface_pad_key")
    @ColumnTitle("加密密钥")
    private String interfacePadKey;

    /**
     * 对称加密算法模式
     */
    @NotEmpty
    @Length(max=25)
    @Column(name = "interface_add_pass")
    @ColumnTitle("对称加密算法模式")
    private String interfaceAddPass;

    /**
     * 数据加密密匙偏移量
     */
    @NotEmpty
    @Length(max=50)
    @Column(name = "interface_pass_py")
    @ColumnTitle("数据加密密匙偏移量")
    private String interfacePassPy;

    /**
     * zip压缩的配置选项:0 无压缩；1 Zip压缩格式
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "interface_zip")
    @ColumnTitle("zip压缩的配置选项:0")
    private String interfaceZip;

    /**
     * 哈希算法：0 无哈希；1 MD5；2 SHA-1
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "interface_hash")
    @ColumnTitle("哈希算法：0")
    private String interfaceHash;

    /**
     * 加密的配置选项：0 不进行加密，明文传输；1  AES加密算法
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "interface_encode")
    @ColumnTitle("加密的配置选项：0")
    private String interfaceEncode;

    /**
     * 封堵类型
     */
    @Length(max=255)
    @Column(name = "block_type")
    @ColumnTitle("封堵类型")
    private String blockType;

    /**
     * 1-内部接口模式、1-外部接口模式
     */
    @Length(max=1)
    @Column(name = "deploy_mode")
    @ColumnTitle("1-内部接口模式、1-外部接口模式")
    private String deployMode;

    /**
     * 上传FTP用户设置
     */
    @NotEmpty
    @Length(max=20)
    @Column(name = "interface_ftp_name")
    @ColumnTitle("上传FTP用户设置")
    private String interfaceFtpName;

    /**
     * 上传FTP密码设置
     */
    @NotEmpty
    @Length(max=50)
    @Column(name = "interface_ftp_pwd")
    @ColumnTitle("上传FTP密码设置")
    private String interfaceFtpPwd;

    /**
     * 上传FTP路径设置
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "interface_ftp_path")
    @ColumnTitle("上传FTP路径设置")
    private String interfaceFtpPath;

    /**
     * FTP服务器IP设置
     */
    @NotEmpty
    @Length(max=100)
    @Column(name = "interface_ftp_url")
    @ColumnTitle("FTP服务器IP设置")
    private String interfaceFtpUrl;

    /**
     * FTP服务器端口设置
     */
    @NotEmpty
    @Length(max=100)
    @Column(name = "interface_ftp_port")
    @ColumnTitle("FTP服务器端口设置")
    private String interfaceFtpPort;

    /**
     * FTP野蛮模式开关:(主动模式) 0 关闭:(野蛮模式) 1 开启.
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "interface_ftp_Passive")
    @ColumnTitle("FTP野蛮模式开关:(主动模式)")
    private String interfaceFtpPassive;

    /**
     * 加密进制 分Y–16进制和N-2进制
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "interface_pwd_hex")
    @ColumnTitle("加密进制")
    private String interfacePwdHex;

    /**
     * WebServce调用地址
     */
    @NotEmpty
    @Length(max=255)
    @Column(name = "interface_ws_url")
    @ColumnTitle("WebServce调用地址")
    private String interfaceWsUrl;

    /**
     * 是否有效(Y-有效 N-无效)
     */
    @Length(max=1)
    @Column(name = "show_mk")
    @ColumnTitle("是否有效(Y-有效")
    private String showMk;

    /**
     * 标准版本号
     */
    @NotEmpty
    @Length(max=4)
    @Column(name = "commandVersion")
    @ColumnTitle("标准版本号")
    private String commandversion;

    /**
     * eu调用eum接口地址ACK使用
     */
    @Length(max=255)
    @Column(name = "interface_eum_url")
    @ColumnTitle("eu调用eum接口地址ACK使用")
    private String interfaceEumUrl;

    /**
     * du供eu使用的ftp IP
     */
    @Length(max=15)
    @Column(name = "du_ftp_ip")
    @ColumnTitle("du供eu使用的ftp")
    private String duFtpIp;

    /**
     * du供eu使用的ftp 账户名
     */
    @Length(max=255)
    @Column(name = "du_ftp_user")
    @ColumnTitle("du供eu使用的ftp")
    private String duFtpUser;

    /**
     * du供eu使用的ftp 密码
     */
    @Length(max=255)
    @Column(name = "du_ftp_pwd")
    @ColumnTitle("du供eu使用的ftp")
    private String duFtpPwd;

    /**
     * du供eu使用的ftp 端口号
     */
    @Length(max=5)
    @Column(name = "du_ftp_port")
    @ColumnTitle("du供eu使用的ftp")
    private String duFtpPort;

    /**
     * du供eu使用的ftp 路径
     */
    @Length(max=255)
    @Column(name = "du_ftp_dir")
    @ColumnTitle("du供eu使用的ftp")
    private String duFtpDir;

    /**
     * du供eu使用的备用ftp IP
     */
    @Length(max=15)
    @Column(name = "du_bak_ftp_ip")
    @ColumnTitle("du供eu使用的备用ftp")
    private String duBakFtpIp;

    /**
     * du供eu使用的备用ftp 账户
     */
    @Length(max=255)
    @Column(name = "du_bak_ftp_user")
    @ColumnTitle("du供eu使用的备用ftp")
    private String duBakFtpUser;

    /**
     * du供eu使用的备用ftp 密码
     */
    @Length(max=255)
    @Column(name = "du_bak_ftp_pwd")
    @ColumnTitle("du供eu使用的备用ftp")
    private String duBakFtpPwd;

    /**
     * du供eu使用的备用ftp 端口号
     */
    @Length(max=5)
    @Column(name = "du_bak_ftp_port")
    @ColumnTitle("du供eu使用的备用ftp")
    private String duBakFtpPort;

    /**
     * du供eu使用的备用ftp 路径
     */
    @Length(max=255)
    @Column(name = "du_bak_ftp_dir")
    @ColumnTitle("du供eu使用的备用ftp")
    private String duBakFtpDir;

    /**
     * 病毒还原文件大小
     */
    @Length(max=19)
    @Column(name = "max_content_file_size")
    @ColumnTitle("病毒还原文件大小")
    private String maxContentFileSize;

    /**
     * 疑似病毒监测配置
     */
    @Length(max=19)
    @Column(name = "enable_suspected_viruse")
    @ColumnTitle("疑似病毒监测配置")
    private String enableSuspectedViruse;

    /**
     * 升级IP
     */
    @Length(max=64)
    @Column(name = "update_server_ip")
    @ColumnTitle("升级IP")
    private String updateServerIp;

    /**
     * 是否已经下发(0：未下发，1：已下发)
     */
    @Column(name = "is_sent")
    @ColumnTitle("是否已经下发(0：未下发，1：已下发)")
    private Integer isSent;

    /**
     * 供CU，EU,DU等升级的，升级IP
     */
    @Length(max=64)
    @Column(name = "update_system_ip")
    @ColumnTitle("供CU，EU,DU等升级的，升级IP")
    private String updateSystemIp;

    /**
     * 封堵页面跳转标志：1--默认封堵  2--url  3--html
     */
    @NotEmpty
    @Length(max=1)
    @Column(name = "block_page_mark")
    @ColumnTitle("封堵页面跳转标志：1--默认封堵")
    private String blockPageMark;

    /**
     * cu ftp类型（0：ftp;1:xftp）
     */
    @Column(name = "ftp_type")
    @ColumnTitle("cu")
    private Integer ftpType;

    /**
     * cu ftp模式（0：主动模式;1:被动模式）
     */
    @Column(name = "ftp_mode")
    @ColumnTitle("cu")
    private Integer ftpMode;

    /**
     * du ftp类型（0：ftp;1:xftp）
     */
    @Column(name = "ftp_type_du")
    @ColumnTitle("du")
    private Integer ftpTypeDu;

    /**
     * du ftp模式（0：主动模式;1:被动模式）
     */
    @Column(name = "ftp_mode_du")
    @ColumnTitle("du")
    private Integer ftpModeDu;

    /**
     * du备份 ftp类型（0：ftp;1:xftp）
     */
    @Column(name = "ftp_type_du_bak")
    @ColumnTitle("du备份")
    private Integer ftpTypeDuBak;

    /**
     * du备份 ftp模式（0：主动模式;1:被动模式）
     */
    @Column(name = "ftp_mode_du_bak")
    @ColumnTitle("du备份")
    private Integer ftpModeDuBak;

    /**
     * 封堵页面跳转的url
     */
    @Length(max=65535)
    @Column(name = "block_page_url")
    @ColumnTitle("封堵页面跳转的url")
    private String blockPageUrl;

    /**
     * 封堵页面跳转的HTML
     */
    @Length(max=65535)
    @Column(name = "block_page_content")
    @ColumnTitle("封堵页面跳转的HTML")
    private String blockPageContent;

    public static final String Property_FtpMode = "ftpMode";

    public static final String Property_MaxContentFileSize = "maxContentFileSize";

    public static final String Property_BlockPageMark = "blockPageMark";

    public static final String Property_InterfaceId = "interfaceId";

    public static final String Property_BlockPageContent = "blockPageContent";

    public static final String Property_DuFtpPort = "duFtpPort";

    public static final String Property_FtpModeDu = "ftpModeDu";

    public static final String Property_DuFtpPwd = "duFtpPwd";

    public static final String Property_UpdateServerIp = "updateServerIp";

    public static final String Property_InterfaceFtpPwd = "interfaceFtpPwd";

    public static final String Property_InterfaceFtpPort = "interfaceFtpPort";

    public static final String Property_BlockPageUrl = "blockPageUrl";

    public static final String Property_InterfaceUserPass = "interfaceUserPass";

    public static final String Property_FtpType = "ftpType";

    public static final String Property_FtpTypeDuBak = "ftpTypeDuBak";

    public static final String Property_IsSent = "isSent";

    public static final String Property_DuFtpUser = "duFtpUser";

    public static final String Property_ServiceCode = "serviceCode";

    public static final String Property_DuBakFtpDir = "duBakFtpDir";

    public static final String Property_DuBakFtpIp = "duBakFtpIp";

    public static final String Property_InterfaceWsUrl = "interfaceWsUrl";

    public static final String Property_FtpTypeDu = "ftpTypeDu";

    public static final String Property_InterfaceMsgKey = "interfaceMsgKey";

    public static final String Property_DuBakFtpPwd = "duBakFtpPwd";

    public static final String Property_DeployMode = "deployMode";

    public static final String Property_InterfaceType = "interfaceType";

    public static final String Property_InterfaceFtpUrl = "interfaceFtpUrl";

    public static final String Property_InterfaceZip = "interfaceZip";

    public static final String Property_InterfacePassPy = "interfacePassPy";

    public static final String Property_InterfacePwdHex = "interfacePwdHex";

    public static final String Property_InterfaceName = "interfaceName";

    public static final String Property_InterfaceEumUrl = "interfaceEumUrl";

    public static final String Property_DuBakFtpUser = "duBakFtpUser";

    public static final String Property_InterfacePadKey = "interfacePadKey";

    public static final String Property_InterfaceHash = "interfaceHash";

    public static final String Property_EnableSuspectedViruse = "enableSuspectedViruse";

    public static final String Property_DuBakFtpPort = "duBakFtpPort";

    public static final String Property_UpdateSystemIp = "updateSystemIp";

    public static final String Property_InterfaceFtpPath = "interfaceFtpPath";

    public static final String Property_ShowMk = "showMk";

    public static final String Property_FtpModeDuBak = "ftpModeDuBak";

    public static final String Property_InterfaceFtpPassive = "interfaceFtpPassive";

    public static final String Property_InterfaceEncode = "interfaceEncode";

    public static final String Property_InterfaceAddPass = "interfaceAddPass";

    public static final String Property_DuFtpDir = "duFtpDir";

    public static final String Property_Commandversion = "commandversion";

    public static final String Property_BlockType = "blockType";

    public static final String Property_InterfaceFtpName = "interfaceFtpName";

    public static final String Property_DuFtpIp = "duFtpIp";

    /**
     * 获取接口系统配置表id
     *
     * @return interface_id - 接口系统配置表id
     */
    public int getInterfaceId() {
        return interfaceId;
    }

    /**
     * 设置接口系统配置表id
     *
     * @param interfaceId 接口系统配置表id
     */
    public void setInterfaceId(int interfaceId) {
        addChangeField("interfaceId",this.interfaceId,interfaceId);
        this.interfaceId = interfaceId;
    }

    /**
     * 获取机房编号
     *
     * @return service_code - 机房编号
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * 设置机房编号
     *
     * @param serviceCode 机房编号
     */
    public void setServiceCode(String serviceCode) {
        addChangeField("serviceCode",this.serviceCode,serviceCode);
        this.serviceCode = serviceCode;
    }

    /**
     * 获取接口系统类型 1-EU 2-备案系统 3-访问日志留存系统
     *
     * @return interface_type - 接口系统类型 1-EU 2-备案系统 3-访问日志留存系统
     */
    public Byte getInterfaceType() {
        return interfaceType;
    }

    /**
     * 设置接口系统类型 1-EU 2-备案系统 3-访问日志留存系统
     *
     * @param interfaceType 接口系统类型 1-EU 2-备案系统 3-访问日志留存系统
     */
    public void setInterfaceType(Byte interfaceType) {
        addChangeField("interfaceType",this.interfaceType,interfaceType);
        this.interfaceType = interfaceType;
    }

    /**
     * 获取接口系统名称
     *
     * @return interface_name - 接口系统名称
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * 设置接口系统名称
     *
     * @param interfaceName 接口系统名称
     */
    public void setInterfaceName(String interfaceName) {
        addChangeField("interfaceName",this.interfaceName,interfaceName);
        this.interfaceName = interfaceName;
    }

    /**
     * 获取用户口令设置
     *
     * @return interface_user_pass - 用户口令设置
     */
    public String getInterfaceUserPass() {
        return interfaceUserPass;
    }

    /**
     * 设置用户口令设置
     *
     * @param interfaceUserPass 用户口令设置
     */
    public void setInterfaceUserPass(String interfaceUserPass) {
        addChangeField("interfaceUserPass",this.interfaceUserPass,interfaceUserPass);
        this.interfaceUserPass = interfaceUserPass;
    }

    /**
     * 获取消息认证密钥
     *
     * @return interface_msg_key - 消息认证密钥
     */
    public String getInterfaceMsgKey() {
        return interfaceMsgKey;
    }

    /**
     * 设置消息认证密钥
     *
     * @param interfaceMsgKey 消息认证密钥
     */
    public void setInterfaceMsgKey(String interfaceMsgKey) {
        addChangeField("interfaceMsgKey",this.interfaceMsgKey,interfaceMsgKey);
        this.interfaceMsgKey = interfaceMsgKey;
    }

    /**
     * 获取加密密钥
     *
     * @return interface_pad_key - 加密密钥
     */
    public String getInterfacePadKey() {
        return interfacePadKey;
    }

    /**
     * 设置加密密钥
     *
     * @param interfacePadKey 加密密钥
     */
    public void setInterfacePadKey(String interfacePadKey) {
        addChangeField("interfacePadKey",this.interfacePadKey,interfacePadKey);
        this.interfacePadKey = interfacePadKey;
    }

    /**
     * 获取对称加密算法模式
     *
     * @return interface_add_pass - 对称加密算法模式
     */
    public String getInterfaceAddPass() {
        return interfaceAddPass;
    }

    /**
     * 设置对称加密算法模式
     *
     * @param interfaceAddPass 对称加密算法模式
     */
    public void setInterfaceAddPass(String interfaceAddPass) {
        addChangeField("interfaceAddPass",this.interfaceAddPass,interfaceAddPass);
        this.interfaceAddPass = interfaceAddPass;
    }

    /**
     * 获取数据加密密匙偏移量
     *
     * @return interface_pass_py - 数据加密密匙偏移量
     */
    public String getInterfacePassPy() {
        return interfacePassPy;
    }

    /**
     * 设置数据加密密匙偏移量
     *
     * @param interfacePassPy 数据加密密匙偏移量
     */
    public void setInterfacePassPy(String interfacePassPy) {
        addChangeField("interfacePassPy",this.interfacePassPy,interfacePassPy);
        this.interfacePassPy = interfacePassPy;
    }

    /**
     * 获取zip压缩的配置选项:0 无压缩；1 Zip压缩格式
     *
     * @return interface_zip - zip压缩的配置选项:0 无压缩；1 Zip压缩格式
     */
    public String getInterfaceZip() {
        return interfaceZip;
    }

    /**
     * 设置zip压缩的配置选项:0 无压缩；1 Zip压缩格式
     *
     * @param interfaceZip zip压缩的配置选项:0 无压缩；1 Zip压缩格式
     */
    public void setInterfaceZip(String interfaceZip) {
        addChangeField("interfaceZip",this.interfaceZip,interfaceZip);
        this.interfaceZip = interfaceZip;
    }

    /**
     * 获取哈希算法：0 无哈希；1 MD5；2 SHA-1
     *
     * @return interface_hash - 哈希算法：0 无哈希；1 MD5；2 SHA-1
     */
    public String getInterfaceHash() {
        return interfaceHash;
    }

    /**
     * 设置哈希算法：0 无哈希；1 MD5；2 SHA-1
     *
     * @param interfaceHash 哈希算法：0 无哈希；1 MD5；2 SHA-1
     */
    public void setInterfaceHash(String interfaceHash) {
        addChangeField("interfaceHash",this.interfaceHash,interfaceHash);
        this.interfaceHash = interfaceHash;
    }

    /**
     * 获取加密的配置选项：0 不进行加密，明文传输；1  AES加密算法
     *
     * @return interface_encode - 加密的配置选项：0 不进行加密，明文传输；1  AES加密算法
     */
    public String getInterfaceEncode() {
        return interfaceEncode;
    }

    /**
     * 设置加密的配置选项：0 不进行加密，明文传输；1  AES加密算法
     *
     * @param interfaceEncode 加密的配置选项：0 不进行加密，明文传输；1  AES加密算法
     */
    public void setInterfaceEncode(String interfaceEncode) {
        addChangeField("interfaceEncode",this.interfaceEncode,interfaceEncode);
        this.interfaceEncode = interfaceEncode;
    }

    /**
     * 获取封堵类型
     *
     * @return block_type - 封堵类型
     */
    public String getBlockType() {
        return blockType;
    }

    /**
     * 设置封堵类型
     *
     * @param blockType 封堵类型
     */
    public void setBlockType(String blockType) {
        addChangeField("blockType",this.blockType,blockType);
        this.blockType = blockType;
    }

    /**
     * 获取1-内部接口模式、1-外部接口模式
     *
     * @return deploy_mode - 1-内部接口模式、1-外部接口模式
     */
    public String getDeployMode() {
        return deployMode;
    }

    /**
     * 设置1-内部接口模式、1-外部接口模式
     *
     * @param deployMode 1-内部接口模式、1-外部接口模式
     */
    public void setDeployMode(String deployMode) {
        addChangeField("deployMode",this.deployMode,deployMode);
        this.deployMode = deployMode;
    }

    /**
     * 获取上传FTP用户设置
     *
     * @return interface_ftp_name - 上传FTP用户设置
     */
    public String getInterfaceFtpName() {
        return interfaceFtpName;
    }

    /**
     * 设置上传FTP用户设置
     *
     * @param interfaceFtpName 上传FTP用户设置
     */
    public void setInterfaceFtpName(String interfaceFtpName) {
        addChangeField("interfaceFtpName",this.interfaceFtpName,interfaceFtpName);
        this.interfaceFtpName = interfaceFtpName;
    }

    /**
     * 获取上传FTP密码设置
     *
     * @return interface_ftp_pwd - 上传FTP密码设置
     */
    public String getInterfaceFtpPwd() {
        return interfaceFtpPwd;
    }

    /**
     * 设置上传FTP密码设置
     *
     * @param interfaceFtpPwd 上传FTP密码设置
     */
    public void setInterfaceFtpPwd(String interfaceFtpPwd) {
        addChangeField("interfaceFtpPwd",this.interfaceFtpPwd,interfaceFtpPwd);
        this.interfaceFtpPwd = interfaceFtpPwd;
    }

    /**
     * 获取上传FTP路径设置
     *
     * @return interface_ftp_path - 上传FTP路径设置
     */
    public String getInterfaceFtpPath() {
        return interfaceFtpPath;
    }

    /**
     * 设置上传FTP路径设置
     *
     * @param interfaceFtpPath 上传FTP路径设置
     */
    public void setInterfaceFtpPath(String interfaceFtpPath) {
        addChangeField("interfaceFtpPath",this.interfaceFtpPath,interfaceFtpPath);
        this.interfaceFtpPath = interfaceFtpPath;
    }

    /**
     * 获取FTP服务器IP设置
     *
     * @return interface_ftp_url - FTP服务器IP设置
     */
    public String getInterfaceFtpUrl() {
        return interfaceFtpUrl;
    }

    /**
     * 设置FTP服务器IP设置
     *
     * @param interfaceFtpUrl FTP服务器IP设置
     */
    public void setInterfaceFtpUrl(String interfaceFtpUrl) {
        addChangeField("interfaceFtpUrl",this.interfaceFtpUrl,interfaceFtpUrl);
        this.interfaceFtpUrl = interfaceFtpUrl;
    }

    /**
     * 获取FTP服务器端口设置
     *
     * @return interface_ftp_port - FTP服务器端口设置
     */
    public String getInterfaceFtpPort() {
        return interfaceFtpPort;
    }

    /**
     * 设置FTP服务器端口设置
     *
     * @param interfaceFtpPort FTP服务器端口设置
     */
    public void setInterfaceFtpPort(String interfaceFtpPort) {
        addChangeField("interfaceFtpPort",this.interfaceFtpPort,interfaceFtpPort);
        this.interfaceFtpPort = interfaceFtpPort;
    }

    /**
     * 获取FTP野蛮模式开关:(主动模式) 0 关闭:(野蛮模式) 1 开启.
     *
     * @return interface_ftp_Passive - FTP野蛮模式开关:(主动模式) 0 关闭:(野蛮模式) 1 开启.
     */
    public String getInterfaceFtpPassive() {
        return interfaceFtpPassive;
    }

    /**
     * 设置FTP野蛮模式开关:(主动模式) 0 关闭:(野蛮模式) 1 开启.
     *
     * @param interfaceFtpPassive FTP野蛮模式开关:(主动模式) 0 关闭:(野蛮模式) 1 开启.
     */
    public void setInterfaceFtpPassive(String interfaceFtpPassive) {
        addChangeField("interfaceFtpPassive",this.interfaceFtpPassive,interfaceFtpPassive);
        this.interfaceFtpPassive = interfaceFtpPassive;
    }

    /**
     * 获取加密进制 分Y–16进制和N-2进制
     *
     * @return interface_pwd_hex - 加密进制 分Y–16进制和N-2进制
     */
    public String getInterfacePwdHex() {
        return interfacePwdHex;
    }

    /**
     * 设置加密进制 分Y–16进制和N-2进制
     *
     * @param interfacePwdHex 加密进制 分Y–16进制和N-2进制
     */
    public void setInterfacePwdHex(String interfacePwdHex) {
        addChangeField("interfacePwdHex",this.interfacePwdHex,interfacePwdHex);
        this.interfacePwdHex = interfacePwdHex;
    }

    /**
     * 获取WebServce调用地址
     *
     * @return interface_ws_url - WebServce调用地址
     */
    public String getInterfaceWsUrl() {
        return interfaceWsUrl;
    }

    /**
     * 设置WebServce调用地址
     *
     * @param interfaceWsUrl WebServce调用地址
     */
    public void setInterfaceWsUrl(String interfaceWsUrl) {
        addChangeField("interfaceWsUrl",this.interfaceWsUrl,interfaceWsUrl);
        this.interfaceWsUrl = interfaceWsUrl;
    }

    /**
     * 获取是否有效(Y-有效 N-无效)
     *
     * @return show_mk - 是否有效(Y-有效 N-无效)
     */
    public String getShowMk() {
        return showMk;
    }

    /**
     * 设置是否有效(Y-有效 N-无效)
     *
     * @param showMk 是否有效(Y-有效 N-无效)
     */
    public void setShowMk(String showMk) {
        addChangeField("showMk",this.showMk,showMk);
        this.showMk = showMk;
    }

    /**
     * 获取标准版本号
     *
     * @return commandVersion - 标准版本号
     */
    public String getCommandversion() {
        return commandversion;
    }

    /**
     * 设置标准版本号
     *
     * @param commandversion 标准版本号
     */
    public void setCommandversion(String commandversion) {
        addChangeField("commandversion",this.commandversion,commandversion);
        this.commandversion = commandversion;
    }

    /**
     * 获取eu调用eum接口地址ACK使用
     *
     * @return interface_eum_url - eu调用eum接口地址ACK使用
     */
    public String getInterfaceEumUrl() {
        return interfaceEumUrl;
    }

    /**
     * 设置eu调用eum接口地址ACK使用
     *
     * @param interfaceEumUrl eu调用eum接口地址ACK使用
     */
    public void setInterfaceEumUrl(String interfaceEumUrl) {
        addChangeField("interfaceEumUrl",this.interfaceEumUrl,interfaceEumUrl);
        this.interfaceEumUrl = interfaceEumUrl;
    }

    /**
     * 获取du供eu使用的ftp IP
     *
     * @return du_ftp_ip - du供eu使用的ftp IP
     */
    public String getDuFtpIp() {
        return duFtpIp;
    }

    /**
     * 设置du供eu使用的ftp IP
     *
     * @param duFtpIp du供eu使用的ftp IP
     */
    public void setDuFtpIp(String duFtpIp) {
        addChangeField("duFtpIp",this.duFtpIp,duFtpIp);
        this.duFtpIp = duFtpIp;
    }

    /**
     * 获取du供eu使用的ftp 账户名
     *
     * @return du_ftp_user - du供eu使用的ftp 账户名
     */
    public String getDuFtpUser() {
        return duFtpUser;
    }

    /**
     * 设置du供eu使用的ftp 账户名
     *
     * @param duFtpUser du供eu使用的ftp 账户名
     */
    public void setDuFtpUser(String duFtpUser) {
        addChangeField("duFtpUser",this.duFtpUser,duFtpUser);
        this.duFtpUser = duFtpUser;
    }

    /**
     * 获取du供eu使用的ftp 密码
     *
     * @return du_ftp_pwd - du供eu使用的ftp 密码
     */
    public String getDuFtpPwd() {
        return duFtpPwd;
    }

    /**
     * 设置du供eu使用的ftp 密码
     *
     * @param duFtpPwd du供eu使用的ftp 密码
     */
    public void setDuFtpPwd(String duFtpPwd) {
        addChangeField("duFtpPwd",this.duFtpPwd,duFtpPwd);
        this.duFtpPwd = duFtpPwd;
    }

    /**
     * 获取du供eu使用的ftp 端口号
     *
     * @return du_ftp_port - du供eu使用的ftp 端口号
     */
    public String getDuFtpPort() {
        return duFtpPort;
    }

    /**
     * 设置du供eu使用的ftp 端口号
     *
     * @param duFtpPort du供eu使用的ftp 端口号
     */
    public void setDuFtpPort(String duFtpPort) {
        addChangeField("duFtpPort",this.duFtpPort,duFtpPort);
        this.duFtpPort = duFtpPort;
    }

    /**
     * 获取du供eu使用的ftp 路径
     *
     * @return du_ftp_dir - du供eu使用的ftp 路径
     */
    public String getDuFtpDir() {
        return duFtpDir;
    }

    /**
     * 设置du供eu使用的ftp 路径
     *
     * @param duFtpDir du供eu使用的ftp 路径
     */
    public void setDuFtpDir(String duFtpDir) {
        addChangeField("duFtpDir",this.duFtpDir,duFtpDir);
        this.duFtpDir = duFtpDir;
    }

    /**
     * 获取du供eu使用的备用ftp IP
     *
     * @return du_bak_ftp_ip - du供eu使用的备用ftp IP
     */
    public String getDuBakFtpIp() {
        return duBakFtpIp;
    }

    /**
     * 设置du供eu使用的备用ftp IP
     *
     * @param duBakFtpIp du供eu使用的备用ftp IP
     */
    public void setDuBakFtpIp(String duBakFtpIp) {
        addChangeField("duBakFtpIp",this.duBakFtpIp,duBakFtpIp);
        this.duBakFtpIp = duBakFtpIp;
    }

    /**
     * 获取du供eu使用的备用ftp 账户
     *
     * @return du_bak_ftp_user - du供eu使用的备用ftp 账户
     */
    public String getDuBakFtpUser() {
        return duBakFtpUser;
    }

    /**
     * 设置du供eu使用的备用ftp 账户
     *
     * @param duBakFtpUser du供eu使用的备用ftp 账户
     */
    public void setDuBakFtpUser(String duBakFtpUser) {
        addChangeField("duBakFtpUser",this.duBakFtpUser,duBakFtpUser);
        this.duBakFtpUser = duBakFtpUser;
    }

    /**
     * 获取du供eu使用的备用ftp 密码
     *
     * @return du_bak_ftp_pwd - du供eu使用的备用ftp 密码
     */
    public String getDuBakFtpPwd() {
        return duBakFtpPwd;
    }

    /**
     * 设置du供eu使用的备用ftp 密码
     *
     * @param duBakFtpPwd du供eu使用的备用ftp 密码
     */
    public void setDuBakFtpPwd(String duBakFtpPwd) {
        addChangeField("duBakFtpPwd",this.duBakFtpPwd,duBakFtpPwd);
        this.duBakFtpPwd = duBakFtpPwd;
    }

    /**
     * 获取du供eu使用的备用ftp 端口号
     *
     * @return du_bak_ftp_port - du供eu使用的备用ftp 端口号
     */
    public String getDuBakFtpPort() {
        return duBakFtpPort;
    }

    /**
     * 设置du供eu使用的备用ftp 端口号
     *
     * @param duBakFtpPort du供eu使用的备用ftp 端口号
     */
    public void setDuBakFtpPort(String duBakFtpPort) {
        addChangeField("duBakFtpPort",this.duBakFtpPort,duBakFtpPort);
        this.duBakFtpPort = duBakFtpPort;
    }

    /**
     * 获取du供eu使用的备用ftp 路径
     *
     * @return du_bak_ftp_dir - du供eu使用的备用ftp 路径
     */
    public String getDuBakFtpDir() {
        return duBakFtpDir;
    }

    /**
     * 设置du供eu使用的备用ftp 路径
     *
     * @param duBakFtpDir du供eu使用的备用ftp 路径
     */
    public void setDuBakFtpDir(String duBakFtpDir) {
        addChangeField("duBakFtpDir",this.duBakFtpDir,duBakFtpDir);
        this.duBakFtpDir = duBakFtpDir;
    }

    /**
     * 获取病毒还原文件大小
     *
     * @return max_content_file_size - 病毒还原文件大小
     */
    public String getMaxContentFileSize() {
        return maxContentFileSize;
    }

    /**
     * 设置病毒还原文件大小
     *
     * @param maxContentFileSize 病毒还原文件大小
     */
    public void setMaxContentFileSize(String maxContentFileSize) {
        addChangeField("maxContentFileSize",this.maxContentFileSize,maxContentFileSize);
        this.maxContentFileSize = maxContentFileSize;
    }

    /**
     * 获取疑似病毒监测配置
     *
     * @return enable_suspected_viruse - 疑似病毒监测配置
     */
    public String getEnableSuspectedViruse() {
        return enableSuspectedViruse;
    }

    /**
     * 设置疑似病毒监测配置
     *
     * @param enableSuspectedViruse 疑似病毒监测配置
     */
    public void setEnableSuspectedViruse(String enableSuspectedViruse) {
        addChangeField("enableSuspectedViruse",this.enableSuspectedViruse,enableSuspectedViruse);
        this.enableSuspectedViruse = enableSuspectedViruse;
    }

    /**
     * 获取升级IP
     *
     * @return update_server_ip - 升级IP
     */
    public String getUpdateServerIp() {
        return updateServerIp;
    }

    /**
     * 设置升级IP
     *
     * @param updateServerIp 升级IP
     */
    public void setUpdateServerIp(String updateServerIp) {
        addChangeField("updateServerIp",this.updateServerIp,updateServerIp);
        this.updateServerIp = updateServerIp;
    }

    /**
     * 获取是否已经下发(0：未下发，1：已下发)
     *
     * @return is_sent - 是否已经下发(0：未下发，1：已下发)
     */
    public Integer getIsSent() {
        return isSent;
    }

    /**
     * 设置是否已经下发(0：未下发，1：已下发)
     *
     * @param isSent 是否已经下发(0：未下发，1：已下发)
     */
    public void setIsSent(Integer isSent) {
        addChangeField("isSent",this.isSent,isSent);
        this.isSent = isSent;
    }

    /**
     * 获取供CU，EU,DU等升级的，升级IP
     *
     * @return update_system_ip - 供CU，EU,DU等升级的，升级IP
     */
    public String getUpdateSystemIp() {
        return updateSystemIp;
    }

    /**
     * 设置供CU，EU,DU等升级的，升级IP
     *
     * @param updateSystemIp 供CU，EU,DU等升级的，升级IP
     */
    public void setUpdateSystemIp(String updateSystemIp) {
        addChangeField("updateSystemIp",this.updateSystemIp,updateSystemIp);
        this.updateSystemIp = updateSystemIp;
    }

    /**
     * 获取封堵页面跳转标志：1--默认封堵  2--url  3--html
     *
     * @return block_page_mark - 封堵页面跳转标志：1--默认封堵  2--url  3--html
     */
    public String getBlockPageMark() {
        return blockPageMark;
    }

    /**
     * 设置封堵页面跳转标志：1--默认封堵  2--url  3--html
     *
     * @param blockPageMark 封堵页面跳转标志：1--默认封堵  2--url  3--html
     */
    public void setBlockPageMark(String blockPageMark) {
        addChangeField("blockPageMark",this.blockPageMark,blockPageMark);
        this.blockPageMark = blockPageMark;
    }

    /**
     * 获取cu ftp类型（0：ftp;1:xftp）
     *
     * @return ftp_type - cu ftp类型（0：ftp;1:xftp）
     */
    public Integer getFtpType() {
        return ftpType;
    }

    /**
     * 设置cu ftp类型（0：ftp;1:xftp）
     *
     * @param ftpType cu ftp类型（0：ftp;1:xftp）
     */
    public void setFtpType(Integer ftpType) {
        addChangeField("ftpType",this.ftpType,ftpType);
        this.ftpType = ftpType;
    }

    /**
     * 获取cu ftp模式（0：主动模式;1:被动模式）
     *
     * @return ftp_mode - cu ftp模式（0：主动模式;1:被动模式）
     */
    public Integer getFtpMode() {
        return ftpMode;
    }

    /**
     * 设置cu ftp模式（0：主动模式;1:被动模式）
     *
     * @param ftpMode cu ftp模式（0：主动模式;1:被动模式）
     */
    public void setFtpMode(Integer ftpMode) {
        addChangeField("ftpMode",this.ftpMode,ftpMode);
        this.ftpMode = ftpMode;
    }

    /**
     * 获取du ftp类型（0：ftp;1:xftp）
     *
     * @return ftp_type_du - du ftp类型（0：ftp;1:xftp）
     */
    public Integer getFtpTypeDu() {
        return ftpTypeDu;
    }

    /**
     * 设置du ftp类型（0：ftp;1:xftp）
     *
     * @param ftpTypeDu du ftp类型（0：ftp;1:xftp）
     */
    public void setFtpTypeDu(Integer ftpTypeDu) {
        addChangeField("ftpTypeDu",this.ftpTypeDu,ftpTypeDu);
        this.ftpTypeDu = ftpTypeDu;
    }

    /**
     * 获取du ftp模式（0：主动模式;1:被动模式）
     *
     * @return ftp_mode_du - du ftp模式（0：主动模式;1:被动模式）
     */
    public Integer getFtpModeDu() {
        return ftpModeDu;
    }

    /**
     * 设置du ftp模式（0：主动模式;1:被动模式）
     *
     * @param ftpModeDu du ftp模式（0：主动模式;1:被动模式）
     */
    public void setFtpModeDu(Integer ftpModeDu) {
        addChangeField("ftpModeDu",this.ftpModeDu,ftpModeDu);
        this.ftpModeDu = ftpModeDu;
    }

    /**
     * 获取du备份 ftp类型（0：ftp;1:xftp）
     *
     * @return ftp_type_du_bak - du备份 ftp类型（0：ftp;1:xftp）
     */
    public Integer getFtpTypeDuBak() {
        return ftpTypeDuBak;
    }

    /**
     * 设置du备份 ftp类型（0：ftp;1:xftp）
     *
     * @param ftpTypeDuBak du备份 ftp类型（0：ftp;1:xftp）
     */
    public void setFtpTypeDuBak(Integer ftpTypeDuBak) {
        addChangeField("ftpTypeDuBak",this.ftpTypeDuBak,ftpTypeDuBak);
        this.ftpTypeDuBak = ftpTypeDuBak;
    }

    /**
     * 获取du备份 ftp模式（0：主动模式;1:被动模式）
     *
     * @return ftp_mode_du_bak - du备份 ftp模式（0：主动模式;1:被动模式）
     */
    public Integer getFtpModeDuBak() {
        return ftpModeDuBak;
    }

    /**
     * 设置du备份 ftp模式（0：主动模式;1:被动模式）
     *
     * @param ftpModeDuBak du备份 ftp模式（0：主动模式;1:被动模式）
     */
    public void setFtpModeDuBak(Integer ftpModeDuBak) {
        addChangeField("ftpModeDuBak",this.ftpModeDuBak,ftpModeDuBak);
        this.ftpModeDuBak = ftpModeDuBak;
    }

    /**
     * 获取封堵页面跳转的url
     *
     * @return block_page_url - 封堵页面跳转的url
     */
    public String getBlockPageUrl() {
        return blockPageUrl;
    }

    /**
     * 设置封堵页面跳转的url
     *
     * @param blockPageUrl 封堵页面跳转的url
     */
    public void setBlockPageUrl(String blockPageUrl) {
        addChangeField("blockPageUrl",this.blockPageUrl,blockPageUrl);
        this.blockPageUrl = blockPageUrl;
    }

    /**
     * 获取封堵页面跳转的HTML
     *
     * @return block_page_content - 封堵页面跳转的HTML
     */
    public String getBlockPageContent() {
        return blockPageContent;
    }

    /**
     * 设置封堵页面跳转的HTML
     *
     * @param blockPageContent 封堵页面跳转的HTML
     */
    public void setBlockPageContent(String blockPageContent) {
        addChangeField("blockPageContent",this.blockPageContent,blockPageContent);
        this.blockPageContent = blockPageContent;
    }
}