//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from: ChatMessage.proto
namespace com.game.proto
{
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"ResPersonalNoticeMessage")]
  public partial class ResPersonalNoticeMessage : global::ProtoBuf.IExtensible
  {
    public ResPersonalNoticeMessage() {}
    
    private com.game.proto.Protos_Chat _msgID = com.game.proto.Protos_Chat.ResPersonalNotice;
    [global::ProtoBuf.ProtoMember(1, IsRequired = false, Name=@"msgID", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(com.game.proto.Protos_Chat.ResPersonalNotice)]
    public com.game.proto.Protos_Chat msgID
    {
      get { return _msgID; }
      set { _msgID = value; }
    }
    private long _sendFrom = default(long);
    [global::ProtoBuf.ProtoMember(2, IsRequired = false, Name=@"sendFrom", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendFrom
    {
      get { return _sendFrom; }
      set { _sendFrom = value; }
    }
    private long _sendTo = default(long);
    [global::ProtoBuf.ProtoMember(3, IsRequired = false, Name=@"sendTo", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendTo
    {
      get { return _sendTo; }
      set { _sendTo = value; }
    }
    private int _type;
    [global::ProtoBuf.ProtoMember(4, IsRequired = true, Name=@"type", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int type
    {
      get { return _type; }
      set { _type = value; }
    }
    private int _contentIndex = default(int);
    [global::ProtoBuf.ProtoMember(5, IsRequired = false, Name=@"contentIndex", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(int))]
    public int contentIndex
    {
      get { return _contentIndex; }
      set { _contentIndex = value; }
    }
    private string _content = "";
    [global::ProtoBuf.ProtoMember(6, IsRequired = false, Name=@"content", DataFormat = global::ProtoBuf.DataFormat.Default)]
    [global::System.ComponentModel.DefaultValue("")]
    public string content
    {
      get { return _content; }
      set { _content = value; }
    }
    private readonly global::System.Collections.Generic.List<string> _values = new global::System.Collections.Generic.List<string>();
    [global::ProtoBuf.ProtoMember(7, Name=@"values", DataFormat = global::ProtoBuf.DataFormat.Default)]
    public global::System.Collections.Generic.List<string> values
    {
      get { return _values; }
    }
  
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"ResMonsterTalkMessage")]
  public partial class ResMonsterTalkMessage : global::ProtoBuf.IExtensible
  {
    public ResMonsterTalkMessage() {}
    
    private com.game.proto.Protos_Chat _msgID = com.game.proto.Protos_Chat.ResMonsterTalk;
    [global::ProtoBuf.ProtoMember(1, IsRequired = false, Name=@"msgID", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(com.game.proto.Protos_Chat.ResMonsterTalk)]
    public com.game.proto.Protos_Chat msgID
    {
      get { return _msgID; }
      set { _msgID = value; }
    }
    private long _sendFrom = default(long);
    [global::ProtoBuf.ProtoMember(2, IsRequired = false, Name=@"sendFrom", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendFrom
    {
      get { return _sendFrom; }
      set { _sendFrom = value; }
    }
    private long _sendTo = default(long);
    [global::ProtoBuf.ProtoMember(3, IsRequired = false, Name=@"sendTo", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendTo
    {
      get { return _sendTo; }
      set { _sendTo = value; }
    }
    private long _monsterID;
    [global::ProtoBuf.ProtoMember(4, IsRequired = true, Name=@"monsterID", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public long monsterID
    {
      get { return _monsterID; }
      set { _monsterID = value; }
    }
    private int _contentIndex = default(int);
    [global::ProtoBuf.ProtoMember(5, IsRequired = false, Name=@"contentIndex", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(int))]
    public int contentIndex
    {
      get { return _contentIndex; }
      set { _contentIndex = value; }
    }
    private string _content = "";
    [global::ProtoBuf.ProtoMember(6, IsRequired = false, Name=@"content", DataFormat = global::ProtoBuf.DataFormat.Default)]
    [global::System.ComponentModel.DefaultValue("")]
    public string content
    {
      get { return _content; }
      set { _content = value; }
    }
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"ReqGoodsInfo")]
  public partial class ReqGoodsInfo : global::ProtoBuf.IExtensible
  {
    public ReqGoodsInfo() {}
    
    private int _goodsid;
    [global::ProtoBuf.ProtoMember(1, IsRequired = true, Name=@"goodsid", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int goodsid
    {
      get { return _goodsid; }
      set { _goodsid = value; }
    }
    private int _backpackType;
    [global::ProtoBuf.ProtoMember(2, IsRequired = true, Name=@"backpackType", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int backpackType
    {
      get { return _backpackType; }
      set { _backpackType = value; }
    }
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"GoodsAddition")]
  public partial class GoodsAddition : global::ProtoBuf.IExtensible
  {
    public GoodsAddition() {}
    
    private int _type;
    [global::ProtoBuf.ProtoMember(1, IsRequired = true, Name=@"type", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int type
    {
      get { return _type; }
      set { _type = value; }
    }
    private int _hide;
    [global::ProtoBuf.ProtoMember(2, IsRequired = true, Name=@"hide", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int hide
    {
      get { return _hide; }
      set { _hide = value; }
    }
    private int _value1;
    [global::ProtoBuf.ProtoMember(3, IsRequired = true, Name=@"value1", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int value1
    {
      get { return _value1; }
      set { _value1 = value; }
    }
    private int _value2;
    [global::ProtoBuf.ProtoMember(4, IsRequired = true, Name=@"value2", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int value2
    {
      get { return _value2; }
      set { _value2 = value; }
    }
    private int _randMaxVal;
    [global::ProtoBuf.ProtoMember(5, IsRequired = true, Name=@"randMaxVal", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int randMaxVal
    {
      get { return _randMaxVal; }
      set { _randMaxVal = value; }
    }
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"GoodsInfo")]
  public partial class GoodsInfo : global::ProtoBuf.IExtensible
  {
    public GoodsInfo() {}
    
    private long _id;
    [global::ProtoBuf.ProtoMember(1, IsRequired = true, Name=@"id", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public long id
    {
      get { return _id; }
      set { _id = value; }
    }
    private int _type;
    [global::ProtoBuf.ProtoMember(2, IsRequired = true, Name=@"type", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int type
    {
      get { return _type; }
      set { _type = value; }
    }
    private int _modelId;
    [global::ProtoBuf.ProtoMember(3, IsRequired = true, Name=@"modelId", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int modelId
    {
      get { return _modelId; }
      set { _modelId = value; }
    }
    private int _count;
    [global::ProtoBuf.ProtoMember(4, IsRequired = true, Name=@"count", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int count
    {
      get { return _count; }
      set { _count = value; }
    }
    private long _createTime;
    [global::ProtoBuf.ProtoMember(5, IsRequired = true, Name=@"createTime", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public long createTime
    {
      get { return _createTime; }
      set { _createTime = value; }
    }
    private int _packageId = default(int);
    [global::ProtoBuf.ProtoMember(6, IsRequired = false, Name=@"packageId", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(int))]
    public int packageId
    {
      get { return _packageId; }
      set { _packageId = value; }
    }
    private int _gridId = default(int);
    [global::ProtoBuf.ProtoMember(7, IsRequired = false, Name=@"gridId", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(int))]
    public int gridId
    {
      get { return _gridId; }
      set { _gridId = value; }
    }
    private int _durability = default(int);
    [global::ProtoBuf.ProtoMember(8, IsRequired = false, Name=@"durability", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(int))]
    public int durability
    {
      get { return _durability; }
      set { _durability = value; }
    }
    private string _maker = "";
    [global::ProtoBuf.ProtoMember(9, IsRequired = false, Name=@"maker", DataFormat = global::ProtoBuf.DataFormat.Default)]
    [global::System.ComponentModel.DefaultValue("")]
    public string maker
    {
      get { return _maker; }
      set { _maker = value; }
    }
    private bool _bind = default(bool);
    [global::ProtoBuf.ProtoMember(10, IsRequired = false, Name=@"bind", DataFormat = global::ProtoBuf.DataFormat.Default)]
    [global::System.ComponentModel.DefaultValue(default(bool))]
    public bool bind
    {
      get { return _bind; }
      set { _bind = value; }
    }
    private long _losttime = default(long);
    [global::ProtoBuf.ProtoMember(11, IsRequired = false, Name=@"losttime", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long losttime
    {
      get { return _losttime; }
      set { _losttime = value; }
    }
    private com.game.proto.GoodsAddition _addition = null;
    [global::ProtoBuf.ProtoMember(13, IsRequired = false, Name=@"addition", DataFormat = global::ProtoBuf.DataFormat.Default)]
    [global::System.ComponentModel.DefaultValue(null)]
    public com.game.proto.GoodsAddition addition
    {
      get { return _addition; }
      set { _addition = value; }
    }
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"ReqChatMessage")]
  public partial class ReqChatMessage : global::ProtoBuf.IExtensible
  {
    public ReqChatMessage() {}
    
    private com.game.proto.Protos_Chat _msgID = com.game.proto.Protos_Chat.ReqChat;
    [global::ProtoBuf.ProtoMember(1, IsRequired = false, Name=@"msgID", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(com.game.proto.Protos_Chat.ReqChat)]
    public com.game.proto.Protos_Chat msgID
    {
      get { return _msgID; }
      set { _msgID = value; }
    }
    private long _sendFrom = default(long);
    [global::ProtoBuf.ProtoMember(2, IsRequired = false, Name=@"sendFrom", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendFrom
    {
      get { return _sendFrom; }
      set { _sendFrom = value; }
    }
    private long _sendTo = default(long);
    [global::ProtoBuf.ProtoMember(3, IsRequired = false, Name=@"sendTo", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendTo
    {
      get { return _sendTo; }
      set { _sendTo = value; }
    }
    private int _chatType;
    [global::ProtoBuf.ProtoMember(4, IsRequired = true, Name=@"chatType", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int chatType
    {
      get { return _chatType; }
      set { _chatType = value; }
    }
    private string _content;
    [global::ProtoBuf.ProtoMember(5, IsRequired = true, Name=@"content", DataFormat = global::ProtoBuf.DataFormat.Default)]
    public string content
    {
      get { return _content; }
      set { _content = value; }
    }
    private long _sendToPlayerID = default(long);
    [global::ProtoBuf.ProtoMember(6, IsRequired = false, Name=@"sendToPlayerID", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendToPlayerID
    {
      get { return _sendToPlayerID; }
      set { _sendToPlayerID = value; }
    }
    private string _sendToPlayerName = "";
    [global::ProtoBuf.ProtoMember(7, IsRequired = false, Name=@"sendToPlayerName", DataFormat = global::ProtoBuf.DataFormat.Default)]
    [global::System.ComponentModel.DefaultValue("")]
    public string sendToPlayerName
    {
      get { return _sendToPlayerName; }
      set { _sendToPlayerName = value; }
    }
    private long _goodsid = default(long);
    [global::ProtoBuf.ProtoMember(8, IsRequired = false, Name=@"goodsid", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long goodsid
    {
      get { return _goodsid; }
      set { _goodsid = value; }
    }
    private int _backpackType = default(int);
    [global::ProtoBuf.ProtoMember(9, IsRequired = false, Name=@"backpackType", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(int))]
    public int backpackType
    {
      get { return _backpackType; }
      set { _backpackType = value; }
    }
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
  [global::System.Serializable, global::ProtoBuf.ProtoContract(Name=@"ResPushMessage")]
  public partial class ResPushMessage : global::ProtoBuf.IExtensible
  {
    public ResPushMessage() {}
    
    private com.game.proto.Protos_Chat _msgID = com.game.proto.Protos_Chat.ResChat;
    [global::ProtoBuf.ProtoMember(1, IsRequired = false, Name=@"msgID", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(com.game.proto.Protos_Chat.ResChat)]
    public com.game.proto.Protos_Chat msgID
    {
      get { return _msgID; }
      set { _msgID = value; }
    }
    private long _sendFrom = default(long);
    [global::ProtoBuf.ProtoMember(2, IsRequired = false, Name=@"sendFrom", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendFrom
    {
      get { return _sendFrom; }
      set { _sendFrom = value; }
    }
    private long _sendTo = default(long);
    [global::ProtoBuf.ProtoMember(3, IsRequired = false, Name=@"sendTo", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    [global::System.ComponentModel.DefaultValue(default(long))]
    public long sendTo
    {
      get { return _sendTo; }
      set { _sendTo = value; }
    }
    private int _chatType;
    [global::ProtoBuf.ProtoMember(4, IsRequired = true, Name=@"chatType", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int chatType
    {
      get { return _chatType; }
      set { _chatType = value; }
    }
    private int _isgm;
    [global::ProtoBuf.ProtoMember(5, IsRequired = true, Name=@"isgm", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int isgm
    {
      get { return _isgm; }
      set { _isgm = value; }
    }
    private long _sendPlayerID;
    [global::ProtoBuf.ProtoMember(6, IsRequired = true, Name=@"sendPlayerID", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public long sendPlayerID
    {
      get { return _sendPlayerID; }
      set { _sendPlayerID = value; }
    }
    private string _sendPlayerName;
    [global::ProtoBuf.ProtoMember(7, IsRequired = true, Name=@"sendPlayerName", DataFormat = global::ProtoBuf.DataFormat.Default)]
    public string sendPlayerName
    {
      get { return _sendPlayerName; }
      set { _sendPlayerName = value; }
    }
    private int _sendPlayerlevel;
    [global::ProtoBuf.ProtoMember(8, IsRequired = true, Name=@"sendPlayerlevel", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int sendPlayerlevel
    {
      get { return _sendPlayerlevel; }
      set { _sendPlayerlevel = value; }
    }
    private int _vipLevel;
    [global::ProtoBuf.ProtoMember(9, IsRequired = true, Name=@"vipLevel", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int vipLevel
    {
      get { return _vipLevel; }
      set { _vipLevel = value; }
    }
    private int _camp;
    [global::ProtoBuf.ProtoMember(10, IsRequired = true, Name=@"camp", DataFormat = global::ProtoBuf.DataFormat.TwosComplement)]
    public int camp
    {
      get { return _camp; }
      set { _camp = value; }
    }
    private string _content;
    [global::ProtoBuf.ProtoMember(11, IsRequired = true, Name=@"content", DataFormat = global::ProtoBuf.DataFormat.Default)]
    public string content
    {
      get { return _content; }
      set { _content = value; }
    }
    private com.game.proto.GoodsInfo _goods = null;
    [global::ProtoBuf.ProtoMember(12, IsRequired = false, Name=@"goods", DataFormat = global::ProtoBuf.DataFormat.Default)]
    [global::System.ComponentModel.DefaultValue(null)]
    public com.game.proto.GoodsInfo goods
    {
      get { return _goods; }
      set { _goods = value; }
    }
    private global::ProtoBuf.IExtension extensionObject;
    global::ProtoBuf.IExtension global::ProtoBuf.IExtensible.GetExtensionObject(bool createIfMissing)
      { return global::ProtoBuf.Extensible.GetExtensionObject(ref extensionObject, createIfMissing); }
  }
  
    [global::ProtoBuf.ProtoContract(Name=@"Protos_Chat")]
    public enum Protos_Chat
    {
            
      [global::ProtoBuf.ProtoEnum(Name=@"ResPersonalNotice", Value=800201)]
      ResPersonalNotice = 800201,
            
      [global::ProtoBuf.ProtoEnum(Name=@"ResMonsterTalk", Value=800202)]
      ResMonsterTalk = 800202,
            
      [global::ProtoBuf.ProtoEnum(Name=@"ReqChat", Value=800208)]
      ReqChat = 800208,
            
      [global::ProtoBuf.ProtoEnum(Name=@"ResChat", Value=800108)]
      ResChat = 800108
    }
  
    [global::ProtoBuf.ProtoContract(Name=@"Protos_ChatType")]
    public enum Protos_ChatType
    {
            
      [global::ProtoBuf.ProtoEnum(Name=@"CHATTYPE_WORLD", Value=0)]
      CHATTYPE_WORLD = 0,
            
      [global::ProtoBuf.ProtoEnum(Name=@"CHATTYPE_SCENE", Value=1)]
      CHATTYPE_SCENE = 1,
            
      [global::ProtoBuf.ProtoEnum(Name=@"CHATTYPE_GROUP", Value=2)]
      CHATTYPE_GROUP = 2,
            
      [global::ProtoBuf.ProtoEnum(Name=@"CHATTYPE_TEAM", Value=3)]
      CHATTYPE_TEAM = 3,
            
      [global::ProtoBuf.ProtoEnum(Name=@"CHATTYPE_ROLE", Value=4)]
      CHATTYPE_ROLE = 4,
            
      [global::ProtoBuf.ProtoEnum(Name=@"CHATTYPE_SYSTEM", Value=5)]
      CHATTYPE_SYSTEM = 5,
            
      [global::ProtoBuf.ProtoEnum(Name=@"CHATTYPE_LABA", Value=99)]
      CHATTYPE_LABA = 99
    }
  
}