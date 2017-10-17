package me.jamiethompson.forge.TabActivity;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import me.jamiethompson.forge.Data.ForgeAccount;
import me.jamiethompson.forge.Files.FileManager;
import me.jamiethompson.forge.ListView.AccountListAdapter;
import me.jamiethompson.forge.R;
import me.jamiethompson.forge.ReloadInterface;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment implements ListView.OnItemClickListener, ReloadInterface {

    private View view;
    private HashMap<UUID, ForgeAccount> accounts;
    private ListView accountList;

    public static StoreFragment newInstance() {
        StoreFragment fragment = new StoreFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        this.view = view;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        accounts = new HashMap<>();
        accountList = this.view.findViewById(R.id.account_list);
        accountList.setOnItemClickListener(this);
        setUpList();
        load(getActivity());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ForgeAccount account = (ForgeAccount) adapterView.getItemAtPosition(i);
        ((Forge) getActivity()).loadAccount(account);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        view = null;
    }


    @Override
    public void reload(Activity activity) {
        load(activity);
    }

    public void load(Activity activity) {
        accounts = FileManager.load(activity);
        if (accountList != null) {
            setUpList();
        }
    }

    public void setUpList() {
        if (!accounts.isEmpty()) {
            accountList.setAdapter(null);
        }
        AccountListAdapter adapter = new AccountListAdapter(getContext(), R.layout.item_account, new ArrayList<>(accounts.values()), getActivity(), this);
        accountList.setAdapter(adapter);
    }


}