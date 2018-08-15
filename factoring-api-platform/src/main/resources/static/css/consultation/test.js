define("xsell/base/control", ["xsell/base/jq/jquery", "xsell/base/control_conf", "xsell/base/control/root", "xsell/base/conf", "xsell/base/class", "xsell/base/control/tree", "xsell/base/control/express", "xsell/base/control/load_check", "xsell/base/control/comid", "xsell/base/control/info", "xsell/base/utils/tools", "xsell/base/utils/log"], function (t, i, e) {
    var n = t("xsell/base/jq/jquery"), r = t("xsell/base/control_conf"), s = t("xsell/base/control/root"), o = (t("xsell/base/conf"), t("xsell/base/class")), a = t("xsell/base/control/tree"), l = t("xsell/base/control/express"), h = t("xsell/base/control/load_check"), u = t("xsell/base/control/comid"), c = t("xsell/base/control/info"), f = t("xsell/base/utils/tools"), d = t("xsell/base/utils/log"), _ = new o, p = {}, v = [], b = [], y = 0, g = Object.defineProperty, x = 0, m = [], w = 0, E = [], q = o.extend({
        init: {
            value: function (t) {
                var i = this, e = [].slice.call(arguments);
                t === !0 && e.shift();
                var n, r = e[0];
                if (t === !0) {
                    var o = e[1];
                    for (n in o)this.define(n, o[n])
                }
                return this.define("data", r), m.forEach(function (t) {
                    t.call(i, r, s, e)
                }), this
            }
        }, $container: {
            get: function () {
                return this.__.$container
            }, set: function (t) {
                return this.container = t.get(0), t
            }
        }, container: {
            get: function () {
                return this.__.container || document.createElement("div")
            }, set: function (t) {
                var i = n(t);
                this.__.$container = i, this.__.container = t, i.attr("control_type", this.type).attr("control_classpath", this.classpath), this.id && i.attr("control_id", this.id), this.comid && (i.get(0).id = this.comid), h.add(this), this.fire("containerReplace"), this.bindEvent()
            }
        }, bindEvent: {
            value: function () {
                var t = this;
                this.__.$container.on("click", function (i) {
                    t.postMessage("container.click", {id: t.id, target: this})
                })
            }
        }, define: {
            value: function (t, i) {
                t in this || g(this, t, {value: i, writable: !1, enumerable: !0})
            }, writable: !1
        }, items: {
            get: function () {
                return this.__.children.slice()
            }
        }, controls: {
            get: function () {
                return E
            }
        }, subtree: {
            value: function (t) {
                for (var i = this; i = i.parent;)i && t.call(this, i)
            }
        }, each: {
            value: function (t) {
                return this.items.forEach(function (i) {
                    t.call(i), i.each(t)
                }), this
            }
        }, value: {
            set: function (t) {
                return C(this.__.value, t) ? t : (this.fire("change", this.__.value = t), l.callExpress(this), t)
            }, get: function () {
                return this.__.value
            }
        }, text: {
            set: function (t) {
                return C(this.__.text, t) ? t : (this.fire("textChange", this.__.text = t), l.callExpress(this), t)
            }, get: function () {
                return this.__.text
            }
        }, valueof: {
            set: function (t) {
                var i = this.root.get(t);
                i && void 0 != i.value && (this.value = i.value)
            }, get: function () {
                return this.__.value
            }
        }, label: {
            get: function () {
                return this.__.label
            }, set: function (t) {
                return this.__.label === t ? t : this.fire("label", t) ? this.__.label = t : void 0
            }
        }, readonly: {
            get: function () {
                return !!this.__.readonly
            }, set: function (t) {
                return this.__.readonly === t ? t : this.fire("readonly", !!t) ? this.__.readonly = !!t : void 0
            }
        }, required: {
            get: function () {
                return !!this.__.required
            }, set: function (t) {
                return this.__.required === !!t ? !!t : this.fire("required", !!t) ? this.__.required = !!t : void 0
            }
        }, buildControlUrl: {
            value: function (t) {
                var i = this;
                t.constructor !== Array && (t = [t]), t = t.filter(function (t) {
                    return "type" in t && t.type in r ? (y++, n.inArray(t.type, v) < 0 && (v.push(t.type), b.push(r[t.type])), t.items && t.items.length > 0 && i.buildControlUrl(t.items), !0) : (console.error("妯″潡閿欒! 鎵句笉鍒版ā鍧�:" + t.type + ", ID:" + (t.id || t.comid)), !1)
                })
            }
        }, loadControl: {
            value: function (i, e) {
                if ("function" != typeof e)return this;
                var n = this;
                return n.buildControlUrl(i), v.length && b.length && t(b, function () {
                    [].forEach.call(arguments, function (t, i) {
                        p[v[i]] = t
                    }), e.apply(n, p)
                }), this
            }
        }, createControl: {
            value: function (t, i) {
                var e = t.type, n = p[e];
                if (n) {
                    y--;
                    var r = new n((!0), t, {parent: this, root: this.root, classpath: i});
                    return E.push(r), this.fire("itemsChange"), t && t.label && !t.items && (r.onMessage("commit.before", function () {
                        if (!r.disable && !r.formValidate())return !1
                    }), r.on("change", function () {
                        r.formValidate()
                    })), r
                }
            }
        }, createControls: {
            value: function (i, e) {
                if ("function" != typeof e)return this;
                var s = this, o = this.__;
                i.constructor !== Array && (i = [i]);
                var a = !1, l = [], h = [];
                if (i = i.filter(function (t) {
                        return "type" in t && t.type in r ? (n.inArray(t.type, v) < 0 && a === !1 && (a = !0), h.push(r[t.type]), l.push(t.type), !0) : (console.error("妯″潡閿欒! 鎵句笉鍒版ā鍧�:" + t.type + ", ID:" + (t.id || t.comid)), !1)
                    }), a)++w, t(h, function () {
                    var t = [];
                    [].forEach.call(arguments, function (e, n) {
                        i[n].type in p || (p[i[n].type] = e);
                        var r = s.createControl(i[n], h[n]);
                        o.children.push(r), t.push(r)
                    }), e.apply(s, t), 0 === --w && 0 == y && s.root.fireReady("ready")
                }); else {
                    var u = [];
                    l.forEach(function (t, e) {
                        var n = s.createControl(i[e], h[e]);
                        o.children.push(n), u.push(n)
                    }), e.apply(s, u), 0 === y && s.root.fireReady("ready")
                }
                return this
            }
        }, formatValue: {
            value: function () {
                return this.value
            }, writable: !0
        }, disable: {
            get: function () {
                if (this.__.disable)return !0;
                for (var t = this; t = t.parent;)if (t.disable)return !0;
                return !1
            }, set: function (t) {
                return this.fire("disable", !!t) !== !1 && (t ? (this.__.disable = !0, this.hide()) : (this.__.disable = !1, this.show())), !!t
            }
        }, display: {
            get: function () {
                return this.__.display
            }
        }, hide: {
            value: function () {
                return this.fire("hide") !== !1 && (this.__.autoHide = !1, this.__.display = !1, this.__.$container.hide()), this
            }, writable: !1
        }, show: {
            value: function () {
                return this.fire("show") !== !1 && (this.__.display = !0, this.__.autoHide = !1, this.__.$container.show()), this
            }, writable: !1
        }, remove: {
            value: function () {
                return this.fire("remove") === !1 ? this : (this.fire("__destruct"), void this.__.$container.remove())
            }, writable: !1
        }, postMessage: {
            value: function (t, i) {
                return _.fire(t, i, this, arguments[2] || !1)
            }, writable: !1
        }, onMessage: {
            value: function (t, i) {
                return _.on(t, i), this.on("__destruct", function () {
                    _.off(t, i)
                }), this
            }, writable: !1
        }, removeMessage: {
            value: function (t, i) {
                return _.off(t, i), this
            }, writable: !1
        }, showError: {
            value: function (t) {
                var i = n('<div class="errors"><ul></ul></div>'), e = i.find("ul");
                t && t.constructor === Array && t.forEach(function (t) {
                    var i = n('<li><i class="icon iconfont icon-removecircle"></i><span class="errorinfo"></span></li>'), r = i.find(".errorinfo");
                    e.append(i), r.html(t)
                }), this.hideError(), this.__.$container.append(i), this.__.errorbox = i, this.fire("showError", i.get(0));
                var r = this;
                return i.find(".fa-close").click(function () {
                    i.remove(), r.__.errorbox = null
                }), this
            }, writable: !0
        }, hideError: {
            value: function () {
                var t = this.__.errorbox;
                return t && t.remove(), this.fire("hideError"), this
            }, writable: !0
        }, showWarning: {
            value: function (t) {
                var i = n('<div class="warning"><ul></ul></div>'), e = i.find("ul");
                t && t.constructor === Array && t.forEach(function (t) {
                    var i = n('<li><i class="icon iconfont icon-exclamationcircle"></i><span class="warninginfo"></span></li>'), r = i.find(".warninginfo");
                    e.append(i), r.html(t)
                }), this.hideError(), this.__.$container.append(i), this.__.errorbox = i, this.fire("showWarning", i.get(0));
                var r = this;
                return i.find(".fa-close").click(function () {
                    i.remove(), r.__.errorbox = null
                }), this
            }, writable: !0
        }, hideWarning: {
            value: function () {
                var t = this.__.errorbox;
                return t && t.remove(), this.fire("hideWarning"), this
            }, writable: !0
        }, info: {
            value: function (t, i) {
                var e = this.__.infoPropsRewrite;
                e[t] = {insert: i}
            }, writable: !0
        }, quantityReadonly: {
            get: function () {
                return !!this.__.quantityReadonly
            }, set: function (t) {
                return this.fire("quantityReadonly", !!t) !== !1 && (t ? this.__.quantityReadonly = !0 : this.__.quantityReadonly = !1), !!t
            }
        }, formValidate: {
            value: function () {
                return this.required && f.isEmpty(this.value) ? (d.log(this.label + ":蹇呭～椤逛笉鑳戒负绌猴紒"), this.showError(["蹇呭～椤逛笉鑳戒负绌猴紒"]), !1) : (this.hideError(), !0)
            }, writable: !0
        }
    }), C = function (t, i) {
        if (t === i)return !0;
        if (typeof t == typeof i && t && i)try {
            var e = window.JSON.stringify, t = e(t), i = e(i);
            return t === i
        } catch (n) {
        }
        return !1
    }, R = function (t) {
        "__" in t || g(t, "__", {value: {children: [], display: !0, uid: x++}})
    };
    R(s), q.map = r, m.push(function (t, i) {
        R(this), this.root || (i.page = this, this.root = i, this.parent = i), this.define("originalData", t), this.define("type", t.type), this.define("isDaily", i.isDaily()), t.id && (this.define("id", t.id), a.add(this)), t.comid && (this.define("comid", t.comid), u.add(this)), "extraData" in t || (t.extraData = {})
    }), m.push(function (t, i, e) {
        var n = this;
        n.__.infoPropsRewrite = {}, this.createContainer && this.createContainer.apply(this, e), t.info && this.on("load", function () {
            new c(n)
        }), this.on("disable", function (t) {
            t ? this.hide() : this.show()
        })
    }), m.push(function () {
        var t = this;
        "change show hide remove".split(/\s+/).forEach(function (i) {
            t.on(i, function () {
                this.subtree(function (t) {
                    t.fire("subtree." + i, this)
                })
            })
        })
    }), m.push(function () {
        this.__.autoHide = !1, this.on("subtree.hide", function (t) {
            if (t.parent === this) {
                for (var i, e = this.items, n = 0; i = e[n]; n++)if (i.display)return;
                this.hide(), this.__.autoHide = !0
            }
        }), this.on("subtree.show", function (t) {
            t.parent === this && this.__.autoHide && this.show()
        })
    }), m.push(function () {
        this.on("__destruct", function () {
            if (this.parent) {
                var t = this.parent.__.children;
                t.splice(t.indexOf(this), 1), this.fire("itemsChange")
            }
        })
    }), m.push(function (t) {
        var i = this;
        ["label", "required", "readonly", "disable"].forEach(function (e) {
            e in t && (i[e] = t[e])
        }), this.fire("init")
    }), e.exports = q
});