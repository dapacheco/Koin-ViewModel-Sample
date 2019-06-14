# Koin-ViewModel-Sample
Highlight difference between Koin v1 and v2, via a contrived example.


Checkout the `koin1` and `koin2` branches to see the different behaviour.

V1
```
I/KOIN: About to get ViewModel for [A] - named [TileA]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileAViewModel (Kotlin reflection is not available)'(name:'TileA' key:'A') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: +-- 'com.davepacheco.koinsample.model.TileAViewModel'
D/KOIN: |-- find definition in 0.110659 ms
D/KOIN: |-- get instance in 0.53405 ms
I/KOIN: \-- (*) Created
D/KOIN: !-- [com.davepacheco.koinsample.model.TileAViewModel] resolved in 0.883035 ms
I/KOIN: Got TileAViewModel - A - A - 136848558
I/KOIN: About to get ViewModel for [AB] - named [TileA]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileAViewModel (Kotlin reflection is not available)'(name:'TileA' key:'AB') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: +-- 'com.davepacheco.koinsample.model.TileAViewModel'
D/KOIN: |-- find definition in 0.068656 ms
D/KOIN: |-- get instance in 0.12067 ms
I/KOIN: \-- (*) Created
D/KOIN: !-- [com.davepacheco.koinsample.model.TileAViewModel] resolved in 0.386748 ms
I/KOIN: Got TileAViewModel - A - AB - 256630501
I/KOIN: About to get ViewModel for [B] - named [TileB]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileBViewModel (Kotlin reflection is not available)'(name:'TileB' key:'B') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: +-- 'com.davepacheco.koinsample.model.TileBViewModel'
D/KOIN: |-- find definition in 0.055159 ms
D/KOIN: |-- get instance in 0.117647 ms
I/KOIN: \-- (*) Created
D/KOIN: !-- [com.davepacheco.koinsample.model.TileBViewModel] resolved in 0.520766 ms
I/KOIN: Got TileBViewModel - B - B - 86633416
I/KOIN: About to get ViewModel for [BA] - named [TileB]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileBViewModel (Kotlin reflection is not available)'(name:'TileB' key:'BA') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: +-- 'com.davepacheco.koinsample.model.TileBViewModel'
D/KOIN: |-- find definition in 0.040955 ms
D/KOIN: |-- get instance in 0.070363 ms
I/KOIN: \-- (*) Created
D/KOIN: !-- [com.davepacheco.koinsample.model.TileBViewModel] resolved in 0.217743 ms
I/KOIN: Got TileBViewModel - B - BA - 125221959
I/KOIN: About to get ViewModel for [A] - named [TileA]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileAViewModel (Kotlin reflection is not available)'(name:'TileA' key:'A') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: Got TileAViewModel - A - A - 136848558
I/KOIN: About to get ViewModel for [AB] - named [TileA]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileAViewModel (Kotlin reflection is not available)'(name:'TileA' key:'AB') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: Got TileAViewModel - A - AB - 256630501
I/KOIN: About to get ViewModel for [B] - named [TileB]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileBViewModel (Kotlin reflection is not available)'(name:'TileB' key:'B') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: Got TileBViewModel - B - B - 86633416
I/KOIN: About to get ViewModel for [BA] - named [TileB]
D/KOIN: [ViewModel] ~ 'class com.davepacheco.koinsample.model.TileBViewModel (Kotlin reflection is not available)'(name:'TileB' key:'BA') - com.davepacheco.koinsample.MainActivity@17e297f
I/KOIN: Got TileBViewModel - B - BA - 125221959
```

V2
```2019-06-14 17:41:21.938 15028-15028/com.davepacheco.koinsample I/KOIN: About to get ViewModel for [A] - named [TileA]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: +- get 'com.davepacheco.koinsample.model.TileAViewModel'
   D/[Koin]: | create instance for [type:Factory,name:'TileA', primary_type:'com.davepacheco.koinsample.model.TileAViewModel']
   D/[Koin]: +- got 'com.davepacheco.koinsample.model.TileAViewModel' in 0.987615 ms
   D/[Koin]: !- ViewModelProvider got instance in 1.829381
   I/KOIN: Got TileAViewModel - A - A - 190176698
   I/KOIN: About to get ViewModel for [AB] - named [TileA]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: !- ViewModelProvider got instance in 0.007924
   I/KOIN: Got TileAViewModel - A - A - 190176698
   I/KOIN: About to get ViewModel for [B] - named [TileB]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: +- get 'com.davepacheco.koinsample.model.TileBViewModel'
   D/[Koin]: | create instance for [type:Factory,name:'TileB', primary_type:'com.davepacheco.koinsample.model.TileBViewModel']
   D/[Koin]: +- got 'com.davepacheco.koinsample.model.TileBViewModel' in 0.309766 ms
   D/[Koin]: !- ViewModelProvider got instance in 0.54649
   I/KOIN: Got TileBViewModel - B - B - 242490246
   I/KOIN: About to get ViewModel for [BA] - named [TileB]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: !- ViewModelProvider got instance in 0.009871
   I/KOIN: Got TileBViewModel - B - B - 242490246
   I/KOIN: About to get ViewModel for [A] - named [TileA]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: !- ViewModelProvider got instance in 0.010558
   I/KOIN: Got TileAViewModel - A - A - 190176698
   I/KOIN: About to get ViewModel for [AB] - named [TileA]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: !- ViewModelProvider got instance in 0.012872
   I/KOIN: Got TileAViewModel - A - A - 190176698
   I/KOIN: About to get ViewModel for [B] - named [TileB]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: !- ViewModelProvider got instance in 0.011588
   I/KOIN: Got TileBViewModel - B - B - 242490246
   I/KOIN: About to get ViewModel for [BA] - named [TileB]
   D/[Koin]: !- ViewModelProvider getting instance
   D/[Koin]: !- ViewModelProvider got instance in 0.012871
   I/KOIN: Got TileBViewModel - B - B - 242490246

```
